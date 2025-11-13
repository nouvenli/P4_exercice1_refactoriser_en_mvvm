package com.openclassrooms.notes.di

import com.openclassrooms.notes.data.repository.NotesRepository
import com.openclassrooms.notes.data.service.LocalNotesApiService
import com.openclassrooms.notes.data.service.NotesApiService
import com.openclassrooms.notes.domain.repository.INotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn (SingletonComponent::class)

object AppModule {

    /**
     * provide implementation notesApiService
     */
    @Singleton
    @Provides
    fun provideNotesApiService() : NotesApiService {
        return LocalNotesApiService()
    }

    /**
     * provide implementation notesRepository
     */
    @Singleton
    @Provides
    fun provideNotesRepository(
        notesApiService: NotesApiService
    ): INotesRepository {
        return NotesRepository(notesApiService)
    }

}