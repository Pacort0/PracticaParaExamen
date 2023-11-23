package com.example.practicaparaexamen

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun Login(navController: NavHostController, userDao: Dao, context: Context){
    Column {
        Text(text = "Hola")
    }
}