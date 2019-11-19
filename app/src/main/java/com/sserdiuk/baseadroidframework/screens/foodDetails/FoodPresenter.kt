package com.sserdiuk.baseadroidframework.screens.foodDetails

import com.sserdiuk.baseadroidframework.Presenter
import com.sserdiuk.baseadroidframework.data.DetailsItemModel
import com.sserdiuk.baseadroidframework.utils.Constants
import com.sserdiuk.baseadroidframework.utils.NetworkUtil
import com.sserdiuk.baseadroidframework.utils.foodApi.FoodSearchController
import com.sserdiuk.baseadroidframework.utils.foodApi.ItemDetailsRequest

class FoodPresenter : Presenter<FoodCallbacks, FoodRouter>(), ItemDetailsRequest {
    private val searchController: FoodSearchController =
        FoodSearchController(networkUtil = NetworkUtil(Constants.API_URL()), itemRequest = this)

    fun onTakePath(path: String?) {
        if (path.isNullOrEmpty()) router?.closeActivity()
        else searchController.getItemDetails(path)
    }

    override fun onSuccessRequest(item: DetailsItemModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailureRequest(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}