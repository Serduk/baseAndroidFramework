package com.sserdiuk.baseadroidframework.screens.splash

import com.sserdiuk.baseadroidframework.Presenter

class SplashPresenter : Presenter<SplashCallbacks, SplashRouter>() {
    override fun onTakeRouter() {
        super.onTakeRouter()
        router?.navigateToFirstScreen()
    }
}