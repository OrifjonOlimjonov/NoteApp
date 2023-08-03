package uz.orifjon.noteapp.domain.usecase

import uz.orifjon.noteapp.domain.models.Note
import uz.orifjon.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    suspend fun invoke(note: Note) {
        noteRepository.addNote(note)
    }
}