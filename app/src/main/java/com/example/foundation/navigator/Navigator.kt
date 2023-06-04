package com.example.foundation.navigator

import androidx.appcompat.app.AppCompatActivity
import com.example.foundation.views.BaseScreen

interface Navigator {

    fun launch(screen: BaseScreen)

    fun goBack(result: Any? = null)

    fun <T : AppCompatActivity> replaceActivity(clazz: Class<T>)
}