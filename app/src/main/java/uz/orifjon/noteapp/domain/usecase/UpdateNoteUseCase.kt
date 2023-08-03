package uz.orifjon.noteapp.domain.usecase

import uz.orifjon.noteapp.domain.models.Note
import uz.orifjon.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(note: Note){
        noteRepository.updateNote(note)
    }
}