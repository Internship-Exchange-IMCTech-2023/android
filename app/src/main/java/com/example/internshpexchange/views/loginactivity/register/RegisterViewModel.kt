package com.example.internshpexchange.views.loginactivity.register

import com.example.foundation.navigator.Navigator
import com.example.foundation.uiactions.UiActions
import com.example.foundation.views.BaseViewModel
import com.example.internshpexchange.R
import com.example.internshpexchange.views.loginactivity.login.LoginFragment
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel(
    private val navigator: Navigator,
    private val uiActions: UiActions,
    private val auth: FirebaseAuth
) : BaseViewModel() {

    fun register(login: String?, password: String?) {

        if (login.isNullOrEmpty() || password.isNullOrEmpty()) return

        auth.createUserWithEmailAndPassword(login, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navigator.launch(LoginFragment.Screen()     )
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
}