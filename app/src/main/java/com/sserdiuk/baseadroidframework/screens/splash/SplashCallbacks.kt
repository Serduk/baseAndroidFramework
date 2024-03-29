package com.sserdiuk.baseadroidframework.screens.splash

import com.sserdiuk.baseadroidframework.ViewCallback

interface SplashCallbacks : ViewCallback {
    fun loadScreen()
    fun showProgress(progress: Int)
}