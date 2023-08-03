package uz.orifjon.noteapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import uz.orifjon.noteapp.domain.models.Note
import uz.orifjon.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class GetListNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    suspend fun invoke(): Flow<List<Note>> {
        return noteRepository.getList()
    }
}