package com.sserdiuk.baseadroidframework.screens.splash

import android.content.Intent
import android.os.Bundle
import com.sserdiuk.baseadroidframework.BaseActivity
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.screens.main.MainView

class SplashView : BaseActivity(), SplashCallbacks, SplashRouter {
    private val presenter = SplashPresenter()

    override fun navigateToFirstScreen() {
        startActivity(Intent(this, MainView::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.run {
            takeView(this@SplashView)
            takeRouter(this@SplashView)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.run {
            dropView()
            dropRouter()
        }
    }
}
