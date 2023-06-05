package com.example.internshpexchange.views.mainactivity.search.searchbytype

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foundation.views.BaseFragment
import com.example.internshpexchange.databinding.FragmentSearchByTypeBinding
import com.example.internshpexchange.models.InternshipType

class SearchByTypeFragment : BaseFragment() {

    override val viewModel by viewModels<SearchByTypeViewModel> { PagerViewModelFactory(searchType) }

    private lateinit var searchType: InternshipType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getSerializable(ARG_INTERN_TYPE, InternshipType::class.java)!!
        } else {
            requireArguments().getSerializable(ARG_INTERN_TYPE) as InternshipType
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSearchByTypeBinding.inflate(inflater, container, false).also { binding ->
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recycler.adapter = InternAdapter()
    }.root


    companion object {
        const val ARG_INTERN_TYPE = "ARG_INTERN_TYPE"

        fun getInstance(internshipType: InternshipType) : SearchByTypeFragment {
            val f = SearchByTypeFragment()
            f.arguments = bundleOf(ARG_INTERN_TYPE to internshipType)
            return f
        }
    }
}