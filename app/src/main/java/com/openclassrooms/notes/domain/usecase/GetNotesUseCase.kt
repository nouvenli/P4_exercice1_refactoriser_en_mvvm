package com.openclassrooms.notes.domain.usecase

import com.openclassrooms.notes.domain.modele.MyNote
import com.openclassrooms.notes.domain.repository.INotesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase @Inject constructor(
    private val repository: INotesRepository
) {
    operator fun invoke(): Flow<List<MyNote>> {
        return repository.notes
    }
}