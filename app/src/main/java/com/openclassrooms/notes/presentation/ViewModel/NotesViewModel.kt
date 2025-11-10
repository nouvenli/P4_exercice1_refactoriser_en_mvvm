package com.openclassrooms.notes.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.openclassrooms.notes.domain.modele.MyNote
import com.openclassrooms.notes.domain.repository.INotesRepository

import com.openclassrooms.notes.data.repository.NotesRepository
import com.openclassrooms.notes.data.service.NotesApiService
import com.openclassrooms.notes.data.service.LocalNotesApiService

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {

    // 1. Créer le service
    private val notesApiService: NotesApiService = LocalNotesApiService()

    // 2. Injecter le service dans le Repository
    private val notesRepository: INotesRepository = NotesRepository(notesApiService)

    private val _notes = MutableStateFlow<List<MyNote>>(emptyList())
    val notes: StateFlow<List<MyNote>> = _notes.asStateFlow()

    init {
        collectNotes()
    }

    private fun collectNotes() {
        viewModelScope.launch {
            notesRepository.notes.collect { listNotes ->
                _notes.value = listNotes
            }
        }
    }
}