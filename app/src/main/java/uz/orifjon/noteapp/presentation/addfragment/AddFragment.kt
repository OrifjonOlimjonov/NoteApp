package uz.orifjon.noteapp.presentation.addfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.orifjon.noteapp.R
import uz.orifjon.noteapp.databinding.FragmentAddBinding
import uz.orifjon.noteapp.presentation.addfragment.adapter.ColorPickerAdapter

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ColorPickerAdapter
    private lateinit var color:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        adapter = ColorPickerAdapter {colorItem->
            color = colorItem
        }
        binding.colorPicker.adapter = adapter


        binding.apply {
                toolBar.setOnMenuItemClickListener {
                    when(it.itemId){
                        R.id.btnCheck-> {
                            findNavController().popBackStack()
                        }
                    }
                    true
                }

        }



        return binding.root
    }


}