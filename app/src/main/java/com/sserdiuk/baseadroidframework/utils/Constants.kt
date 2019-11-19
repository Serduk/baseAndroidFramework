package com.sserdiuk.baseadroidframework.utils

import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.screens.App

object Constants {
    fun API_URL() = App.appContext!!.getString(R.string.api_url)
}