package com.example.practicaparaexamen

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicaparaexamen.ui.theme.PracticaParaExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaParaExamenTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                val database = UserDatabaseViewModel(context.applicationContext as Application).room
                NavHost(navController = navController, startDestination = "RegistroUsuario"){
                    composable(route="RegistroUsuario"){
                        RegistroUsuario(navController, database.userDao(), context)
                    }
                    composable(route="Login"){
                        Login(navController, database.userDao(), context)
                    }
                    composable(route="Bienvenida"){
                        Bienvenida(navController, database.userDao(), context)
                    }
                }
            }
        }
    }
}
