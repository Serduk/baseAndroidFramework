package com.sserdiuk.baseadroidframework.screens.search

import com.sserdiuk.baseadroidframework.ViewCallback
import com.sserdiuk.baseadroidframework.data.SearchItemModel

interface SearchCallbacks : ViewCallback {
    fun showSearchResults(items: List<SearchItemModel>)
    fun searchItems()
    fun setTextInSearchField(text: String)
    fun showErrorMessage(text: String)
    fun hideErrorMessage()
    fun showProgressBar()
    fun hideProgressBar()
    fun hideResults()
    fun requestSearchFocus()
    fun showWarning(message: String)
}