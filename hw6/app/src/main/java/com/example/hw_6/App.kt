package com.example.hw_6

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        NotesRepository.init(this)
    }
}