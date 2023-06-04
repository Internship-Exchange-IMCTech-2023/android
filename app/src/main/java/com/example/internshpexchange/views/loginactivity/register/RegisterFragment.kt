package com.example.internshpexchange.views.loginactivity.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foundation.views.BaseFragment
import com.example.foundation.views.BaseScreen
import com.example.foundation.views.screenViewModel
import com.example.internshpexchange.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment() {

    class Screen : BaseScreen

    override val viewModel by screenViewModel<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentRegisterBinding.inflate(inflater, container, false). also { binding ->
            binding.registerButton.setOnClickListener {
                val login = binding.loginInputLayout.editText?.text.toString()
                val password = binding.passwordInputLayout.editText?.text.toString()
                viewModel.register(login, password)
            }
        }.root
    }
}