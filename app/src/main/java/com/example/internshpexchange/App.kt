package com.example.internshpexchange

import android.app.Application
import com.example.foundation.BaseApplication
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class App : Application(), BaseApplication {

    private val _singletonScopeDependencies = mutableListOf<Any>()
    override val singletonScopeDependencies = _singletonScopeDependencies

    lateinit var auth: FirebaseAuth

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth
        _singletonScopeDependencies += auth
    }

    companion object {
        const val APP_SHARED_PREF_NAME = "splashSharedPrefs"
        const val KEY_FIRST_START = "firstStartKey"
    }
}