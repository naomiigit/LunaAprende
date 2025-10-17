package com.duoc.lunaaprende.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.viewmodel.QuizViewModel

@Composable
fun Quiz(navController: NavController, vm: QuizViewModel = viewModel()
) {
    val q = vm.pregunta

    var abrirModal by remember { mutableStateOf(false) }
    var esCorrecto by remember { mutableStateOf<Boolean?>(null) }
    var textoSeleccion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Quiz analista", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.lunapiensa),
            contentDescription = "quiz",
            modifier = Modifier.size(300.dp)
        )

        Spacer(Modifier.height(16.dp))
        Text(text = q.texto, fontSize = 16.sp)
        Spacer(Modifier.height(24.dp))

        q.opciones.forEachIndexed { index, texto ->
            Button(
                onClick = {
                    val ok = vm.seleccionar(index)
                    esCorrecto = ok
                    textoSeleccion = texto
                    abrirModal = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(vertical = 6.dp)
            ) { Text(texto) }
        }
    }

    if (abrirModal) {
        val titulo = if (esCorrecto == true) "¡Muy bien!" else "maal…"
        val mensaje = if (esCorrecto == true)
            "¡Respuesta correcta!"
        else
            "Respuesta incorrecta"

        AlertDialog(
            onDismissRequest = {},
            title = { Text(titulo) },
            text = { Text(mensaje) },

            // Botón principal
            confirmButton = {
                Button(onClick = {
                    abrirModal = false
                    if (esCorrecto == true) {
                        navController.popBackStack("Inicio", inclusive = false)
                    } else {
                    }
                }) {
                    Text(if (esCorrecto == true) "Volver a Inicio" else "Intentar de nuevo")
                }
            }
        )
    }
}
