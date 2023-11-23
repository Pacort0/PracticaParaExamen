package com.example.practicaparaexamen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavHostController
import com.example.practicaparaexamen.Crud.Crud
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroUsuario(navController: NavHostController, userDao: Dao, context: Context) {
    var usuario by remember{ mutableStateOf("") }
    var password by remember {
        mutableStateOf("")
    }
    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                TextField(value = usuario, onValueChange = {usuario = it}, label = {Text("Usuario")})
        }
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Column {
            Button(onClick = { navController.navigate("Bienvenida")
                Crud.createUser(usuario, password, userDao)
            Log.i("ayuda", "Estoy aquí")} ) {
                Text(text = "Entrar")
            }
            Button(onClick = { navController.navigate("Login") }) {
                Text(text = "Ya tengo una cuenta")
            }
        }
    }
}



