package com.example.internshpexchange.views.mainactivity.responses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshpexchange.databinding.InternshipResponseItemBinding
import com.example.internshpexchange.models.InternshipResponse
import com.example.internshpexchange.models.ResponsesList

class ResponsesAdapter : RecyclerView.Adapter<ResponsesAdapter.Holder>() {

    private val items = ResponsesList().getList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            InternshipResponseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return Holder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    class Holder(private val binding: InternshipResponseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(internItem: InternshipResponse) {
            binding.internNameTextView.text = internItem.internship.name
            binding.companyTextView.text = internItem.internship.company
            binding.priceTextView.text = internItem.internship.price

            with(binding.statusTextView) {
                text = binding.root.context.getString(internItem.status.titleRes)
                setTextColor(binding.root.context.getColor(internItem.status.colorRes))
            }
        }
    }
}