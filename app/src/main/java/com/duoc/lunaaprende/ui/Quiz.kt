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
fun Quiz(navController: NavController, vm: QuizViewModel = viewModel()) {
    val q = vm.preguntaActual

    var abrirModal by remember { mutableStateOf(false) }
    var esCorrecto by remember { mutableStateOf<Boolean?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Quiz analista", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(Modifier.height(6.dp))
        Text(text = "Pregunta ${vm.indiceActual + 1} de ${vm.totalPreguntas}", fontSize = 14.sp)

        Spacer(Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.lunapiensa),
            contentDescription = "quiz",
            modifier = Modifier.size(300.dp)
        )

        Spacer(Modifier.height(16.dp))
        Text(text = q.texto, fontSize = 20.sp)
        Spacer(Modifier.height(24.dp))

        //aca recorremos las opciones y creamos un botones x cada una
        q.opciones.forEachIndexed { index, texto ->
            Button(
                onClick = {
                    esCorrecto = vm.seleccionar(index)
                    abrirModal = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(78.dp)
                    .padding(vertical = 12.dp)
            ) { Text(texto) }
        }
    }

    if (abrirModal) {
        val correcta = (esCorrecto == true)
        val esUltima = !vm.haySiguiente()
        val titulo = if (correcta) "¡Muy bien!" else "Incorrecto"
        val mensaje = if (correcta) "¡Respuesta correcta!" else "Intenta otra vez."

        AlertDialog(
            onDismissRequest = {  },
            title = { Text(titulo) },
            text  = { Text(mensaje) },


            confirmButton = {
                Button(onClick = {
                    abrirModal = false
                    if (correcta) {
                        if (!esUltima) {
                            vm.avanzar()
                        } else {

                            vm.reiniciarQuiz()
                        }
                    } else {
                    }
                }) {
                    Text(
                        when {
                            correcta && !esUltima -> "Siguiente"
                            correcta && esUltima  -> "Hacer otro quiz"
                            else                  -> "Intentar de nuevo"
                        }
                    )
                }
            },


            dismissButton = {
                if (correcta && esUltima) {
                    Button(onClick = {
                        abrirModal = false
                        navController.popBackStack("Menu", inclusive = false)
                    }) {
                        Text("Volver a Menu")
                    }
                }
            }
        )
    }
}