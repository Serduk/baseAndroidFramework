package com.sserdiuk.baseadroidframework.screens.splash

import android.os.CountDownTimer
import com.sserdiuk.baseadroidframework.Presenter

class SplashPresenter : Presenter<SplashCallbacks, SplashRouter>() {
    override fun onTakeRouter() {
        super.onTakeRouter()
        println("On take router")
        loadApp()
    }

    private fun loadApp() {
        object : CountDownTimer(100, 500) {
            override fun onTick(millisUntilFinished: Long) {
                view?.showProgress((millisUntilFinished / 1000).toInt())
            }

            override fun onFinish() {
                router?.navigateToFirstScreen()
            }
        }.start()
    }
}