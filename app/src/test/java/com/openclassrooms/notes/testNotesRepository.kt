package com.openclassrooms.notes

import com.openclassrooms.notes.data.repository.NotesRepository
import com.openclassrooms.notes.data.service.NotesApiService
import com.openclassrooms.notes.domain.modele.MyNote
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * A fake implementation of NotesApiService for testing.
 */
class FakeNotesApiService : NotesApiService {
    val fakeNotes = listOf(
        MyNote("Test Title", "Test Content")
    )

    override fun getAllNotes(): List<MyNote> {
        return fakeNotes
    }

    override fun addNote(note: MyNote) {
        // Not needed for this test
    }
}

class TestNotesRepository {

    @Test
    fun `repository uses injected service`() = runTest {
        // Given
        val fakeApiService = FakeNotesApiService()
        val repository = NotesRepository(fakeApiService)

        // When
        val notes = repository.notes.first()

        // Then
        // Verify that the notes from the repository are the ones from our fake service
        assertEquals(fakeApiService.fakeNotes, notes)

    }
}
