package com.sserdiuk.baseadroidframework.screens.main

import com.sserdiuk.baseadroidframework.Presenter

class MainPresenter : Presenter<MainCallbacks, MainRouter>() {
    fun onButtonClicked() {
        view?.buttonClicked()
    }

    fun onButtonTwoClicked() {
        view?.button1Clicked()
    }

    fun onButtonThreeClicked() {
        router?.navigateToSplashScreen()
    }
}