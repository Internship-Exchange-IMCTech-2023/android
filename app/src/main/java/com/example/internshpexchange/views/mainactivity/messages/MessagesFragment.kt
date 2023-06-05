package com.example.internshpexchange.views.mainactivity.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foundation.views.BaseFragment
import com.example.foundation.views.BaseScreen
import com.example.foundation.views.screenViewModel
import com.example.internshpexchange.databinding.FragmentMessagesBinding

class MessagesFragment : BaseFragment() {

    class Screen : BaseScreen

    override val viewModel by screenViewModel<MessagesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMessagesBinding.inflate(inflater, container, false).root
}