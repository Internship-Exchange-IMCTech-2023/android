package com.example.internshpexchange.views.mainactivity

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.foundation.ActivityScopeViewModel
import com.example.foundation.navigator.IntermediateNavigator
import com.example.foundation.navigator.StackFragmentNavigator
import com.example.foundation.uiactions.AndroidUiActions
import com.example.foundation.utils.viewModelCreator
import com.example.foundation.views.FragmentHolder
import com.example.internshpexchange.R
import com.example.internshpexchange.databinding.ActivityMainBinding
import com.example.internshpexchange.views.mainactivity.messages.MessagesFragment
import com.example.internshpexchange.views.mainactivity.profile.ProfileFragment
import com.example.internshpexchange.views.mainactivity.responses.ResponsesFragment
import com.example.internshpexchange.views.mainactivity.search.SearchFragment

class MainActivity : AppCompatActivity(), FragmentHolder {

    private val activityViewModel by viewModelCreator<ActivityScopeViewModel> {
        ActivityScopeViewModel(
            uiActions = AndroidUiActions(applicationContext), navigator = IntermediateNavigator()
        )
    }

    private lateinit var navigator: StackFragmentNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBackPressedDispatcher.addCallback(onBackPressedCallback)

        navigator = StackFragmentNavigator(
            this, binding.fragmentContainer.id, binding.bottomNavView.id
        ) { SearchFragment.Screen() }

        navigator.onCreate(savedInstanceState)

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_search -> navigator.launch(SearchFragment.Screen())
                R.id.action_profile -> navigator.launch(ProfileFragment.Screen())
                R.id.action_responses -> navigator.launch(ResponsesFragment.Screen())
                R.id.action_messages -> navigator.launch(MessagesFragment.Screen())
                else -> return@setOnItemSelectedListener false
            }
            return@setOnItemSelectedListener true
        }
        binding.bottomNavView.setOnItemReselectedListener {}    // needs to prevent memory leak and reopening tabs
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

    override fun getActivityScopeViewModel(): ActivityScopeViewModel = activityViewModel

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            navigator.onBackPressed()
        }
    }
}