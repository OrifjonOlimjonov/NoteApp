package uz.orifjon.noteapp.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "description")
    val description: String
) : Serializable