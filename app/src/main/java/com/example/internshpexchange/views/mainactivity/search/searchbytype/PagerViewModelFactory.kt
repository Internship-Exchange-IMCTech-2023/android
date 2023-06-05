package com.example.internshpexchange.views.mainactivity.search.searchbytype

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.internshpexchange.models.InternshipType

@Suppress("UNCHECKED_CAST")
class PagerViewModelFactory(
    private val internshipType: InternshipType
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchByTypeViewModel(internshipType) as T
    }
}