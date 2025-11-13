package com.openclassrooms.notes.data.repository

import com.openclassrooms.notes.domain.modele.MyNote
import com.openclassrooms.notes.data.service.NotesApiService
import com.openclassrooms.notes.domain.repository.INotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Repository class for the notes.
 * @param notesApiService The API service for interacting with notes.
 */

class NotesRepository @Inject constructor(
    private val notesApiService: NotesApiService) : INotesRepository {


    /**
     * A flow that emits a list of all notes.
     */
    override val notes: Flow<List<MyNote>> = flow {
        emit(notesApiService.getAllNotes())
    }

    override suspend fun addNote(note: MyNote) {
        TODO("Not yet implemented")
    }
    }
