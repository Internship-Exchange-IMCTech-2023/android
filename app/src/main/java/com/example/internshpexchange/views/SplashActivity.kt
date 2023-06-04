package com.example.internshpexchange.views

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.internshpexchange.App
import com.example.internshpexchange.views.loginactivity.LoginActivity
import com.example.internshpexchange.views.mainactivity.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        installSplashScreen()

        val prefs = getSharedPreferences(App.APP_SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val isFirstStart = prefs.getBoolean(App.KEY_FIRST_START, true)

        val isUserAuthorized = (application as App).auth.currentUser != null

        val intent = if (isFirstStart)
            Intent(this, GuideActivity::class.java)
        else if (isUserAuthorized)
            Intent(this, MainActivity::class.java)
        else
            Intent(this, LoginActivity::class.java)

        startActivity(intent)
        finish()
    }
}