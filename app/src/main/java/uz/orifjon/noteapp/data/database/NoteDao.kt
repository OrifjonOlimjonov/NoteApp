package uz.orifjon.noteapp.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.orifjon.noteapp.domain.models.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note")
    suspend fun getList(): List<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}