package com.example.internshpexchange.views.mainactivity.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foundation.views.BaseFragment
import com.example.foundation.views.BaseScreen
import com.example.foundation.views.screenViewModel
import com.example.internshpexchange.databinding.FragmentSearchBinding
import com.example.internshpexchange.models.InternshipType
import com.example.internshpexchange.views.mainactivity.search.searchbytype.SearchByTypeFragment
import com.google.android.material.tabs.TabLayoutMediator

class SearchFragment : BaseFragment() {

    class Screen : BaseScreen

    override val viewModel by screenViewModel<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSearchBinding.inflate(inflater, container, false).also { binding ->

        with (binding) {

            pager.adapter = PagerAdapter(this@SearchFragment)

            TabLayoutMediator(tabLayout, pager) { tab, position ->
                tab.text = getString(InternshipType.values()[position].nameId)
            }.attach()
        }
    }.root

    private class PagerAdapter(owner: SearchFragment) : FragmentStateAdapter(owner) {
        override fun getItemCount(): Int = InternshipType.values().size

        override fun createFragment(position: Int): Fragment {
            val internType = InternshipType.values()[position]
            return SearchByTypeFragment.getInstance(internType)
        }
    }
}