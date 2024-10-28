package com.nafhan.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nafhan.myapplication.databinding.ItemDisasterBinding

typealias OnClickDisaster = (Email) -> Unit
class EmailAdapter (private val listDisaster : List<Email>, private val onClickDisaster: OnClickDisaster) :
    RecyclerView.Adapter<EmailAdapter.ItemDisasterViewHolder>()  {
    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Email) {
            with(binding) {
                tvName.text = data.nameEmail
                tvDesc.text = data.subject
                tvDate.text = data.date
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding =
            ItemDisasterBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}