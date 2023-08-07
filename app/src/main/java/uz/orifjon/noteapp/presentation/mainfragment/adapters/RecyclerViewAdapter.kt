package uz.orifjon.noteapp.presentation.mainfragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.orifjon.noteapp.databinding.ItemBinding
import uz.orifjon.noteapp.domain.models.Note

class RecyclerViewAdapter : ListAdapter<Note, RecyclerViewAdapter.VH>(MyDiffUtils()) {

    inner class VH(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: Note) {
            binding.tvDescription.text = note.description
        }
    }

    class MyDiffUtils : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }


}