package uz.orifjon.noteapp.presentation.addfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.orifjon.noteapp.R
import uz.orifjon.noteapp.databinding.FragmentAddBinding
import uz.orifjon.noteapp.domain.models.Note
import uz.orifjon.noteapp.presentation.addfragment.adapter.ColorPickerAdapter

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ColorPickerAdapter
    private lateinit var color: String
    private val viewModel: AddFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        adapter = ColorPickerAdapter { colorItem ->
            color = colorItem
        }
        binding.colorPicker.adapter = adapter


        binding.apply {
            toolBar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.btnCheck -> {
                        val noteDescription = editTextDescription.text.toString()
                        val note = Note(id = 0, description = noteDescription, colorNote = color)
                        viewModel.addNote(note)

                        findNavController().popBackStack()
                    }

                    R.id.btnCancel -> {
                        findNavController().popBackStack()
                    }
                }
                true
            }

        }



        return binding.root
    }


}