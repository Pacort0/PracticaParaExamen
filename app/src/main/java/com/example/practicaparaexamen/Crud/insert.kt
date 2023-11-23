package com.example.practicaparaexamen.Crud

import com.example.practicaparaexamen.Dao
import com.example.practicaparaexamen.Usuario
import kotlinx.coroutines.runBlocking

class Crud(){
    companion object{ //clase estática
        fun createUser(usuario:String, password:String, userDao: Dao){
            val nuevoUsuario = Usuario(nombre = usuario, password = password)
            runBlocking { userDao.insertUser(nuevoUsuario) }
        }
    }
}