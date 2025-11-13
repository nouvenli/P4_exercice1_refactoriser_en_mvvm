package com.openclassrooms.notes.presentation.ViewModel

import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.domain.modele.MyNote
import com.openclassrooms.notes.domain.repository.INotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesRepository: INotesRepository
) : ViewModel() {

    // Expose the Repository flow
    val notes: Flow<List<MyNote>> = notesRepository.notes
}