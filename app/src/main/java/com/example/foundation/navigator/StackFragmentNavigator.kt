package com.example.foundation.navigator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.foundation.ARG_SCREEN
import com.example.foundation.utils.Event
import com.example.foundation.views.BaseFragment
import com.example.foundation.views.BaseScreen

class StackFragmentNavigator(
    private val activity: AppCompatActivity,
    @IdRes private val fragmentContainerId: Int,
    private val initialScreenCreator: () -> BaseScreen
) : Navigator {

    private var result: Event<Any>? = null

    override fun launch(screen: BaseScreen) {
        launchFragment(screen)
    }

    override fun goBack(result: Any?) {
        if (result != null) {
            this.result = Event(result)
        }
        activity.onBackPressedDispatcher.onBackPressed()
    }

    override fun <T : AppCompatActivity> replaceActivity(clazz: Class<T>) {
        activity.startActivity(Intent(activity, clazz))
        activity.finish()
    }

    fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            launchFragment(
                screen = initialScreenCreator(),
                addToBackStack = false
            )
        }
        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentCallbacks, false)
    }

    fun onDestroy() {
        activity.supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentCallbacks)
    }

    fun onBackPressed() {
        val f = getCurrentFragment()
        if (f is BaseFragment) {
            f.viewModel.onBackPressed()
        }
        closeScreen()
    }

    private fun launchFragment(screen: BaseScreen, addToBackStack: Boolean = true) {
        // creating fragment from screen
        val fragment = screen.javaClass.enclosingClass.newInstance() as Fragment
        fragment.arguments = bundleOf(ARG_SCREEN to screen)

        val transaction = activity.supportFragmentManager.beginTransaction()
        if (addToBackStack) transaction.addToBackStack(null)
        transaction
            .replace(fragmentContainerId, fragment)
            .commit()
    }

    private fun closeScreen() = with(activity.supportFragmentManager) {
        if (backStackEntryCount > 0)
            activity.supportFragmentManager.popBackStack()
        else
            activity.finish()
    }


    private fun publishResults(fragment: Fragment) {
        val result = result?.getValue() ?: return
        if (fragment is BaseFragment) {
            fragment.viewModel.onResult(result)
        }
    }

    private val fragmentCallbacks = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            publishResults(f)
        }
    }

    private fun getCurrentFragment(): Fragment? =
        activity.supportFragmentManager.findFragmentById(fragmentContainerId)
}