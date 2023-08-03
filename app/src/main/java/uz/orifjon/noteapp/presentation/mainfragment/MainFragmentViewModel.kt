package uz.orifjon.noteapp.presentation.mainfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import uz.orifjon.noteapp.domain.models.Note
import uz.orifjon.noteapp.domain.repository.NoteRepository
import uz.orifjon.noteapp.domain.usecase.AddNoteUseCase
import uz.orifjon.noteapp.domain.usecase.GetListNotesUseCase
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val getListNotesUseCase: GetListNotesUseCase
) : ViewModel() {

    private val _mutableList = MutableStateFlow<List<Note>>(arrayListOf())
    val notes get() = _mutableList.asStateFlow()
    init {
        getList()
    }
    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase.invoke(note)
        }
    }

    fun getList() {
        viewModelScope.launch {
            getListNotesUseCase.invoke().onStart {

            }.catch {

            }.collect {
                    _mutableList.value = it
            }
        }
    }

}