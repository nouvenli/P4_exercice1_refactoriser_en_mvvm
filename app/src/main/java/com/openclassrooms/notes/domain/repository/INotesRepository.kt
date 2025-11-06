package com.openclassrooms.notes.domain.repository

import com.openclassrooms.notes.domain.modele.MyNote
import kotlinx.coroutines.flow.Flow

/**
 * Interface for the notes repository.
 */

interface INotesRepository {
    val notes: Flow<List<MyNote>>
    suspend fun addNote(note: MyNote)
}
