package com.example.foundation.navigator

import androidx.appcompat.app.AppCompatActivity
import com.example.foundation.utils.ResourceActions
import com.example.foundation.views.BaseScreen

class IntermediateNavigator : Navigator {

    private val targetNavigator = ResourceActions<Navigator>()

    override fun launch(screen: BaseScreen) = targetNavigator {
        it.launch(screen)
    }

    override fun goBack(result: Any?) = targetNavigator {
        it.goBack(result)
    }

    override fun <T : AppCompatActivity> replaceActivity(clazz: Class<T>) = targetNavigator {
        it.replaceActivity(clazz)
    }

    fun setTarget(navigator: Navigator?) {
        targetNavigator.resource = navigator
    }

    fun clear() {
        targetNavigator.clear()
    }
}