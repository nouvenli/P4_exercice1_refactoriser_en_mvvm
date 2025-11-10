package com.openclassrooms.notes.data.service

import com.openclassrooms.notes.domain.modele.MyNote
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Tests unitaires pour LocalNotesApiService
 */
class LocalNotesApiServiceTest {

    private lateinit var service: LocalNotesApiService

    @Before
    fun setup() {
        service = LocalNotesApiService()
    }

    @Test
    fun `getAllNotes retourne 10 notes`() {
        // When
        val notes = service.getAllNotes()

        // Then
        assertEquals("Le service devrait retourner 10 notes", 10, notes.size)
    }

    @Test
    fun `toutes les notes ont un titre et un corps non vides`() {
        // When
        val notes = service.getAllNotes()

        // Then
        notes.forEach { note ->
            assertTrue("Le titre ne devrait pas être vide", note.titleNote.isNotEmpty())
            assertTrue("Le corps ne devrait pas être vide", note.bodyNote.isNotEmpty())
        }
    }
}