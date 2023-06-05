package com.example.internshpexchange.views.mainactivity.responses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foundation.views.BaseFragment
import com.example.foundation.views.BaseScreen
import com.example.foundation.views.screenViewModel
import com.example.internshpexchange.databinding.FragmentResponsesBinding

class ResponsesFragment : BaseFragment() {

    class Screen : BaseScreen

    override val viewModel by screenViewModel<ResponsesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentResponsesBinding.inflate(inflater, container, false).also { binding ->
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recycler.adapter = ResponsesAdapter()
    }.root
}