package com.sserdiuk.baseadroidframework.screens.main

import com.sserdiuk.baseadroidframework.Presenter

class MainPresenter : Presenter<MainCallbacks, MainRouter>() {
    fun onButtonClicked() {
        view?.showToast()
    }

    fun onButtonTwoClicked() {
        router?.navigateToSearch()
    }

    fun onButtonThreeClicked() {
        router?.navigateToSplashScreen()
    }
}