package com.openclassrooms.notes.presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.domain.modele.MyNote
import com.openclassrooms.notes.domain.usecase.AddNoteUseCase
import com.openclassrooms.notes.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {

    // Expose the Use Case flow
    val notes: Flow<List<MyNote>> = getNotesUseCase()

    /**
     * Add a note using the use case.
     * @param note The note to add.
     */
    fun addNote(note: MyNote) {
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }
}