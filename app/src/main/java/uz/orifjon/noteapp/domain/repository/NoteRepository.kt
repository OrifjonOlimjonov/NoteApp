package uz.orifjon.noteapp.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.orifjon.noteapp.domain.models.Note


interface NoteRepository {

    suspend fun getList():Flow<List<Note>>

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)
}