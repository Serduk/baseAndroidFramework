package com.sserdiuk.baseadroidframework.screens.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sserdiuk.baseadroidframework.App
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.screens.splash.SplashView

class MainView : AppCompatActivity(), MainRouter, MainCallbacks {
    private val presenter = MainPresenter()

    override fun buttonClicked() {
        App.showToast(this, "Button 1 Clicked!")
    }

    override fun button1Clicked() {
        App.showToast(this, "Button 2 Clicked!")
    }

    override fun navigateToSplashScreen() {
        startActivity(Intent(this, SplashView::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{
            presenter.onButtonClicked()
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener{
            presenter.onButtonTwoClicked()
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener{
            presenter.onButtonThreeClicked()
        }
    }
}
