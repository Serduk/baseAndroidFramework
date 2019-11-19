package com.sserdiuk.baseadroidframework.screens.search

import com.sserdiuk.baseadroidframework.Presenter
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.data.SearchItemModel
import com.sserdiuk.baseadroidframework.screens.App
import com.sserdiuk.baseadroidframework.utils.Constants
import com.sserdiuk.baseadroidframework.utils.NetworkUtil
import com.sserdiuk.baseadroidframework.utils.foodApi.FoodSearchController
import com.sserdiuk.baseadroidframework.utils.foodApi.SearchItemsRequest

class SearchPresenter :
    Presenter<SearchCallbacks, SearchRouter>(), SearchItemsRequest {

    private val searchController: FoodSearchController =
        FoodSearchController(networkUtil = NetworkUtil(Constants.API_URL()), searchRequest = this)
    private lateinit var listItems: List<SearchItemModel>

    fun onItemClicked(position: Int) {
        val item = listItems[position]
        if (item.linkToItem.isNullOrEmpty()) view?.showWarning(App.appContext.getString(R.string.item_not_found))
        else router?.openItem(item.linkToItem ?: "")
    }

    fun onTakeBarcode(result: String?) {
        view?.setTextInSearchField(result ?: "")
        searchByText(result ?: "")
    }

    fun searchByText(text: String?) {
        if (text?.isNotBlank() == true) {
            showSearchProgress()
            searchController.getSearchResults(text)
        }
    }

    fun onActivityOpen() {
        view?.requestSearchFocus()
        onFailureRequest(App.appContext.getString(R.string.try_to_search_something))
    }

    override fun onSuccessRequest(items: List<SearchItemModel>) {
        if (items.isNotEmpty()) {
            view?.run {
                showSearchResults(items)
                hideProgressBar()
                hideErrorMessage()
            }
            listItems = items
            if (listItems.size == 1) onItemClicked(0)
        } else {
            onFailureRequest(App.appContext.getString(R.string.item_not_found))
        }
    }

    override fun onFailureRequest(message: String) {
        view?.run {
            hideProgressBar()
            hideResults()
            showErrorMessage(message)
        }
    }

    private fun showSearchProgress() {
        view?.run {
            hideResults()
            showProgressBar()
            hideErrorMessage()
        }
    }
}