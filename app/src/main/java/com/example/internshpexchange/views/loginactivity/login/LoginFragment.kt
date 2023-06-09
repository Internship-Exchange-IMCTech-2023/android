package com.example.internshpexchange.views.loginactivity.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foundation.views.BaseFragment
import com.example.foundation.views.BaseScreen
import com.example.foundation.views.screenViewModel
import com.example.internshpexchange.databinding.FragmentLoginBinding

class LoginFragment() : BaseFragment() {

    class Screen : BaseScreen

    override val viewModel by screenViewModel<LoginViewModel>()

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            val login = binding.loginInputLayout.editText?.text.toString()
            val password = binding.passwordInputLayout.editText?.text.toString()
            viewModel.login(login, password)
        }

        binding.createAccButton.setOnClickListener {
            viewModel.openRegisterScreen()
        }

        return binding.root
    }
}