package com.example.practicaparaexamen

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kotlinx.coroutines.runBlocking

@Composable
fun Bienvenida(navController: NavHostController, userDao: Dao, context: Context){
        val usuarios: List<Usuario> = runBlocking {
            userDao.getAllUsers()
        }.sortedBy { it.id }
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(1){
            for (usuario in usuarios){
                Column {
                    Text(text = usuario.nombre)
                    Text(text = usuario.password)
                }
            }
        }
    }
}