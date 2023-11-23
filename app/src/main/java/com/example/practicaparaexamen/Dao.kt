package com.example.practicaparaexamen

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM usuarios")
    suspend fun getAllUsers():MutableList<Usuario>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(usuario: Usuario)

    @Delete
    suspend fun deleteUser(usuario: Usuario)
}