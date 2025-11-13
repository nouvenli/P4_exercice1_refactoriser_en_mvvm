package com.openclassrooms.notes.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class to use Hilt
 */
@HiltAndroidApp
class MyNoteApp : Application()