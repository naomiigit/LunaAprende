package com.duoc.lunaaprende.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.viewmodel.QuizState
import com.duoc.lunaaprende.viewmodel.QuizViewModel

@Composable
fun Quiz(navController: NavHostController, vm: QuizViewModel, difficulty: String) {

    val state by vm.state.collectAsState()

    LaunchedEffect(difficulty) {
        vm.cargarPreguntas(difficulty)
    }

    when (state) {
        is QuizState.Idle, is QuizState.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) { Text("Cargando preguntas...") }
            return
        }

        is QuizState.Empty -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("No hay preguntas para esta dificultad.")
                Spacer(Modifier.height(12.dp))
                Button(onClick = { navController.popBackStack() }) {
                    Text("Volver a elegir dificultad")
                }
            }
            return
        }

        is QuizState.Error -> {
            val msg = (state as QuizState.Error).message
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(msg, color = Color.Red)
                Spacer(Modifier.height(12.dp))
                Button(onClick = { vm.cargarPreguntas(difficulty) }) {
                    Text("Reintentar")
                }
            }
            return
        }

        is QuizState.Ready -> {
        }
    }

    val q = vm.preguntaActual ?: return

    var abrirModal by remember { mutableStateOf(false) }
    var esCorrecto by remember { mutableStateOf<Boolean?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Text("Cambiar dificultad")
            }
        }
        Spacer(Modifier.height(16.dp))

        Text("Quiz analista", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(Modifier.height(6.dp))
        Text("Pregunta ${vm.indiceActual + 1} de ${vm.totalPreguntas}", fontSize = 14.sp)

        Spacer(Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.lunapiensa),
            contentDescription = "quiz",
            modifier = Modifier.size(300.dp)
        )

        Spacer(Modifier.height(16.dp))
        Text(q.question_text, fontSize = 20.sp)
        Spacer(Modifier.height(24.dp))

        val opciones = listOf(
            q.alternative_1,
            q.alternative_2,
            q.alternative_3,
            q.alternative_4
        )

        opciones.forEachIndexed { index, texto ->
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
        val imagen = if (correcta) R.drawable.lunacelebra else R.drawable.lunatriste

        AlertDialog(
            onDismissRequest = { },
            icon = {
                Image(
                    painter = painterResource(id = imagen),
                    contentDescription = null,
                    modifier = Modifier.size(160.dp)
                )
            },
            title = {
                Text(
                    text = titulo,
                    color = if (correcta) Color.Green else Color.Red
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 300.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(mensaje)
                    Spacer(Modifier.height(16.dp))

                    if (correcta && esUltima) {
                        Button(
                            onClick = {
                                abrirModal = false
                                navController.navigate("Dificultad") {
                                    popUpTo("Menu") { inclusive = false }
                                    launchSingleTop = true
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Hacer otro quiz")
                        }

                        Spacer(Modifier.height(10.dp))

                        Button(
                            onClick = {
                                abrirModal = false
                                navController.popBackStack("Menu", inclusive = false)
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Volver al menú")
                        }
                    }
                }
            },
            confirmButton = {
                // Solo mostramos el botón si NO es la última pregunta correcta
                if (!(correcta && esUltima)) {
                    Button(
                        onClick = {
                            abrirModal = false
                            // Si la respuesta es correcta, avanzamos.
                            if (correcta) {
                                vm.avanzar()
                            }
                        }
                    ) {
                        Text(
                            if (correcta) "Siguiente" else "Intentar de nuevo"
                        )
                    }
                }
            }
        )
    }
}