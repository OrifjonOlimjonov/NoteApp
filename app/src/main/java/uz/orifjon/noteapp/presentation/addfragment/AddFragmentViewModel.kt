package uz.orifjon.noteapp.presentation.addfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.orifjon.noteapp.domain.models.Note
import uz.orifjon.noteapp.domain.usecase.AddNoteUseCase
import javax.inject.Inject

class AddFragmentViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {


    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase.invoke(note)
        }
    }


}