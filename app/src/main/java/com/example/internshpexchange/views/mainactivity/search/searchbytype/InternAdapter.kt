package com.example.internshpexchange.views.mainactivity.search.searchbytype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshpexchange.databinding.InternshipItemBinding
import com.example.internshpexchange.models.Internship
import com.example.internshpexchange.models.InternshipList

class InternAdapter : RecyclerView.Adapter<InternAdapter.Holder>() {

    private val items = InternshipList().getList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            InternshipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    class Holder(private val binding: InternshipItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(internItem: Internship) {
            binding.internNameTextView.text = internItem.name
            binding.companyTextView.text = internItem.company
            binding.priceTextView.text = internItem.price
        }
    }
}