package com.example.internshpexchange.views.loginactivity.login

import com.example.foundation.navigator.Navigator
import com.example.foundation.uiactions.UiActions
import com.example.foundation.views.BaseViewModel
import com.example.internshpexchange.R
import com.example.internshpexchange.views.loginactivity.register.RegisterFragment
import com.example.internshpexchange.views.mainactivity.MainActivity
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(
    private val navigator: Navigator,
    private val uiActions: UiActions,
    private val auth: FirebaseAuth
) : BaseViewModel() {

    fun login(login: String?, password: String?) {

        if (login.isNullOrEmpty() || password.isNullOrEmpty()) return

        auth.signInWithEmailAndPassword(login, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navigator.replaceActivity(MainActivity::class.java)
                }
                else {
                    val message = when (task.exception) {
                        is FirebaseNetworkException -> uiActions.getString(R.string.network_error)
                        else -> uiActions.getString(R.string.auth_error)
                    }
                    uiActions.toast(message)
                }
            }
    }

    fun openRegisterScreen() {
        navigator.launch(RegisterFragment.Screen())
    }
}