package com.duoc.lunaaprende.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duoc.lunaaprende.R

@Composable
fun SubirApunte(navController: NavController) {
    var mostrarDialogo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Subir apunte",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp)
        Spacer(Modifier.height(8.dp))
        Text("¡Comparte tus notas con tus compañeros!")

        Spacer(Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.lunaapuntes),
            contentDescription = "Gatito con libro",
            modifier = Modifier.size(180.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = { mostrarDialogo = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Tomar foto", fontSize = 18.sp)
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text("Volver al menú", fontSize = 18.sp)
        }
    }

    if (mostrarDialogo) {
        AlertDialog(
            onDismissRequest = { mostrarDialogo = false },
            title = { Text("¡Haz subido tu apunte exitosamente!") },
            confirmButton = {
                Button(onClick = {
                    mostrarDialogo = false
                    navController.popBackStack()
                }) {
                    Text("OK")
                }
            }
        )
    }
}