package com.openclassrooms.notes.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.Domain.MyNote
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {

    private val notesRepository = NotesRepository()

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