package uz.orifjon.noteapp.presentation.addfragment.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.orifjon.noteapp.databinding.ColorItemBinding

class ColorPickerAdapter : RecyclerView.Adapter<ColorPickerAdapter.VH>() {

    inner class VH(var binding: ColorItemBinding) : ViewHolder(binding.root) {
        fun onBind() {
            binding.cardView.setCardBackgroundColor(Color.parseColor("#FFFFFFF"))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ColorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind()
    }
}