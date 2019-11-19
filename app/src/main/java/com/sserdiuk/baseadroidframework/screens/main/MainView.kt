package com.sserdiuk.baseadroidframework.screens.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sserdiuk.baseadroidframework.screens.App
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.screens.search.SearchActivity
import com.sserdiuk.baseadroidframework.screens.splash.SplashView

class MainView : AppCompatActivity(), MainRouter, MainCallbacks {
    private val presenter = MainPresenter()

    override fun showToast() {
        App.showToast(this, "Button 1 Clicked!")
    }

    override fun navigateToSearch() {
        App.showToast(this, "Button 2 Clicked!")
        startActivity(Intent(this, SearchActivity::class.java))
    }

    override fun navigateToSplashScreen() {
        App.showToast(this, "Navigate to splash screen")
        startActivity(Intent(this, SplashView::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.run {
            takeView(this@MainView)
            takeRouter(this@MainView)
        }

        val button: Button = findViewById(R.id.showToast)
        val button2: Button = findViewById(R.id.navigateToSearch)
        val button3: Button = findViewById(R.id.navigateToSplash)

        button.setOnClickListener {
            presenter.onButtonClicked()
        }


        button2.setOnClickListener {
            presenter.onButtonTwoClicked()
        }


        button3.setOnClickListener {
            presenter.onButtonThreeClicked()
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
