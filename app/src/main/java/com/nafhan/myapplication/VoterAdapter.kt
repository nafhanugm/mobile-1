package com.nafhan.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nafhan.myapplication.databinding.ItemVoterBinding
import com.nafhan.myapplication.entity.Voter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil


class VoterAdapter(
    var voters: List<Voter>,
    private val onDeleteClick: (Int) -> Unit,
    private val onEditClick: (Int) -> Unit,
    private val onViewClick: (Int) -> Unit
) : RecyclerView.Adapter<VoterAdapter.VoterViewHolder>() {

    class VoterViewHolder(private val binding: ItemVoterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            voter: Voter,
            position: Int,
            onDeleteClick: (Int) -> Unit,
            onEditClick: (Int) -> Unit,
            onViewClick: (Int) -> Unit
        ) {
            binding.tvNumber.text = (position + 1).toString()
            binding.tvName.text = voter.name

            binding.btnDelete.setOnClickListener { onDeleteClick(position) }
            binding.btnEdit.setOnClickListener { onEditClick(position) }
            binding.btnView.setOnClickListener { onViewClick(position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoterViewHolder {
        val binding = ItemVoterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VoterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoterViewHolder, position: Int) {
        holder.bind(voters[position], position, onDeleteClick, onEditClick, onViewClick)
    }

    override fun getItemCount() = voters.size
}
