package com.example.internshpexchange.views.loginactivity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.foundation.ActivityScopeViewModel
import com.example.foundation.navigator.IntermediateNavigator
import com.example.foundation.navigator.StackFragmentNavigator
import com.example.foundation.uiactions.AndroidUiActions
import com.example.foundation.utils.viewModelCreator
import com.example.foundation.views.FragmentHolder
import com.example.internshpexchange.databinding.ActivityLoginBinding
import com.example.internshpexchange.views.loginactivity.login.LoginFragment

class LoginActivity : AppCompatActivity(), FragmentHolder {

    private val activityViewModel by viewModelCreator<ActivityScopeViewModel> {
        ActivityScopeViewModel(
            navigator = IntermediateNavigator(),
            uiActions = AndroidUiActions(applicationContext)
        )
    }

    private lateinit var navigator: StackFragmentNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBackPressedDispatcher.addCallback(onBackPressedCallback)

        navigator = StackFragmentNavigator(
            this,
            binding.root.id
        ) { LoginFragment.Screen() }
        navigator.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        activityViewModel.navigator.setTarget(navigator)
    }

    override fun onPause() {
        super.onPause()
        activityViewModel.navigator.setTarget(null)
    }

    override fun onDestroy() {
        navigator.onDestroy()
        super.onDestroy()
    }

    override fun notifyScreenUpdates() {}

    override fun getActivityScopeViewModel(): ActivityScopeViewModel = activityViewModel

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            navigator.onBackPressed()
        }
    }
}