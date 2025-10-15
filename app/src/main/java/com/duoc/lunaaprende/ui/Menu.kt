package com.duoc.lunaaprende.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Menu(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("Menú Principal")
        Button(
            onClick = { navController.navigate("quiz") },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Realizar Quiz")
        }
        Button(
            onClick = { navController.navigate("subir_apunte") },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text("Subir Apuntes")
        }
    }
}


