package com.gg.movieapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gg.movieapp.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginActivity.getIntent(this).also {
            startActivity(it)
        }
        finish()
    }
}
