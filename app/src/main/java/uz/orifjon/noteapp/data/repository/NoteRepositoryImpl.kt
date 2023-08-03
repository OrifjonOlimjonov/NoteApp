package uz.orifjon.noteapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import uz.orifjon.noteapp.data.database.NoteDao
import uz.orifjon.noteapp.data.database.NoteDatabase
import uz.orifjon.noteapp.domain.models.Note
import uz.orifjon.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    val noteDatabase: NoteDatabase
):NoteRepository{
    override suspend fun getList(): Flow<List<Note>> {
            return flow {
                emit(noteDatabase.noteDao().getList())
            }
    }

    override suspend fun addNote(note: Note) {
            noteDatabase.noteDao().addNote(note)
    }

    override suspend fun updateNote(note: Note) {
            noteDatabase.noteDao().updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDatabase.noteDao().deleteNote(note)
    }


}