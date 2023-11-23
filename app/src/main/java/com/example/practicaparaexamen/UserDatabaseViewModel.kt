package com.example.practicaparaexamen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.Room

class UserDatabaseViewModel(application: Application): ViewModel() {
    val room: UserDatabase by lazy {
        Room.databaseBuilder(application,UserDatabase::class.java, "usersdb").build()
    }
}