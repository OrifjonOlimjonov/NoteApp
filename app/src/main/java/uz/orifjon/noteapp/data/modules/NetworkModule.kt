package uz.orifjon.noteapp.data.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.orifjon.noteapp.data.database.NoteDatabase
import uz.orifjon.noteapp.data.repository.NoteRepositoryImpl
import uz.orifjon.noteapp.domain.repository.NoteRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providedDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java, "note_database")
            .allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun providedNoteRepository(
        noteDatabase: NoteDatabase
    ): NoteRepository = NoteRepositoryImpl(noteDatabase)

}