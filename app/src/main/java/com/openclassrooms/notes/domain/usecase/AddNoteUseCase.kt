package com.openclassrooms.notes.domain.usecase

import com.openclassrooms.notes.domain.modele.MyNote
import com.openclassrooms.notes.domain.repository.INotesRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: INotesRepository
) {
    suspend operator fun invoke(note: MyNote) {
        repository.addNote(note)
    }
}