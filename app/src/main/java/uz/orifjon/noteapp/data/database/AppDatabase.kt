package uz.orifjon.noteapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.orifjon.noteapp.domain.models.Note


@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}