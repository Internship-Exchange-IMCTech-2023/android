package com.example.internshpexchange.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.internshpexchange.App
import com.example.internshpexchange.databinding.ActivityGuideBinding
import com.example.internshpexchange.views.loginactivity.LoginActivity

class GuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            getSharedPreferences(App.APP_SHARED_PREF_NAME, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(App.KEY_FIRST_START, false)
                .apply()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}