package com.sserdiuk.baseadroidframework.screens.splash

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.sserdiuk.baseadroidframework.BaseActivity
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.screens.main.MainView

class SplashView : BaseActivity(), SplashCallbacks, SplashRouter {
    override fun loadScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(progress: Int) {
        val textView: TextView = findViewById(R.id.timer)
        val stringBuilder = StringBuilder().append(getString(R.string.loading) + " " + progress)
        textView.text = stringBuilder
    }

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
        this.finish()
        presenter.run {
            dropView()
            dropRouter()
        }
    }
}
