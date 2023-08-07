package uz.orifjon.noteapp.presentation.addfragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.orifjon.noteapp.R
import uz.orifjon.noteapp.databinding.FragmentAddBinding
import uz.orifjon.noteapp.presentation.addfragment.adapter.ColorPickerAdapter

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ColorPickerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        adapter = ColorPickerAdapter()
        binding.colorPicker.adapter = adapter




        return binding.root
    }


}