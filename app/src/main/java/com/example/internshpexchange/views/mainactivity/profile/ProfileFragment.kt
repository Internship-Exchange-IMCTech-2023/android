package com.example.internshpexchange.views.mainactivity.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foundation.views.BaseFragment
import com.example.foundation.views.BaseScreen
import com.example.foundation.views.screenViewModel
import com.example.internshpexchange.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment() {

    class Screen : BaseScreen

    override val viewModel by screenViewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProfileBinding.inflate(inflater, container, false).also {

    }.root
}