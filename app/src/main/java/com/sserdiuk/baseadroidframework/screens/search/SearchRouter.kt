package com.sserdiuk.baseadroidframework.screens.search

import com.sserdiuk.baseadroidframework.Router

interface SearchRouter : Router {
    fun openItem(itemPath: String)
}