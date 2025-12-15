package com.duoc.lunaaprende.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.viewmodel.AuthState
import com.duoc.lunaaprende.viewmodel.AuthViewModel
import com.duoc.lunaaprende.viewmodel.RegistroViewModel

@Composable
fun Registro(viewModel: RegistroViewModel, navController: NavHostController) {

    val authVm: AuthViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val registerState by authVm.registerState.collectAsState()
    var mostrarTerminos by remember { mutableStateOf(false) }
    var abrirModal by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.bienvenida),
            contentDescription = "Registro",
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Fit
        )

        OutlinedTextField(
            value = viewModel.registro.nombre,
            onValueChange = { viewModel.registro.nombre = it },
            label = { Text("Ingresa nombre") },
            isError = !viewModel.verificarNombre(),
            supportingText = { Text(viewModel.mensajesError.nombre, color = androidx.compose.ui.graphics.Color.Red) }
        )

        OutlinedTextField(
            value = viewModel.registro.correo,
            onValueChange = { viewModel.registro.correo = it },
            label = { Text("Ingresa correo") },
            isError = !viewModel.verificarCorreo(),
            supportingText = { Text(viewModel.mensajesError.correo, color = androidx.compose.ui.graphics.Color.Red) }
        )

        var ver by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = viewModel.registro.pass,
            onValueChange = { viewModel.registro.pass = it },
            label = { Text("Ingresa una contraseña") },
            isError = !viewModel.verificarPass(),
            supportingText = { Text(viewModel.mensajesError.pass, color = androidx.compose.ui.graphics.Color.Red) },
            visualTransformation = if (ver) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                TextButton(onClick = { ver = !ver }) {
                    Text(if (ver) "Ocultar" else "Ver")
                }
            }
        )

        OutlinedTextField(
            value = viewModel.registro.edad,
            onValueChange = { viewModel.registro.edad = it },
            label = { Text("Ingresa edad") },
            isError = !viewModel.verificarEdad(),
            supportingText = { Text(viewModel.mensajesError.edad, color = androidx.compose.ui.graphics.Color.Red) }
        )


// Terminos y condiciones
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Checkbox(
                    checked = viewModel.registro.terminos,
                    onCheckedChange = { viewModel.registro.terminos = it }
                )

                Text("Acepto los términos")
            }

            TextButton(onClick = { mostrarTerminos = true }) {
                Text("Términos y condiciones")
            }
        }


        Button(
            enabled = viewModel.verificarRegistro() && registerState !is AuthState.Loading,
            onClick = {
                authVm.register(
                    name = viewModel.registro.nombre.trim(),
                    email = viewModel.registro.correo.trim().lowercase(),
                    password = viewModel.registro.pass
                )
            }
        ) {
            Text(if (registerState is AuthState.Loading) "Creando..." else "Continuar")
        }

        // Resultado del registro
        when (val st = registerState) {
            is AuthState.Success -> {
                LaunchedEffect(st.token) {
                    abrirModal = true
                }
            }
            is AuthState.Error -> {
                Spacer(Modifier.height(8.dp))
                Text(st.message, color = androidx.compose.ui.graphics.Color.Red)
            }
            else -> {}
        }

        if (abrirModal) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text("Muy bien") },
                text = { Text("Cuenta creada exitosamente") },
                confirmButton = {
                    Button(onClick = {
                        abrirModal = false
                        authVm.resetRegister()
                        navController.navigate("Menu") {
                            popUpTo("Registro") { inclusive = true }
                        }
                    }) {
                        Text("OK")
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text("¿Ya tienes una cuenta?")
        Button(onClick = { navController.navigate("Inicio") }) {
            Text("Iniciar Sesión")
        }
    }
    if (mostrarTerminos) {
        AlertDialog(
            onDismissRequest = { mostrarTerminos = false },
            confirmButton = {
                Button(onClick = { mostrarTerminos = false }) {
                    Text("Cerrar")
                }
            },
            title = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lunaterminos),
                        contentDescription = "Términos",
                        modifier = Modifier.size(64.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Términos y condiciones",
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .heightIn(max = 320.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text =
                            "Luna Aprende es una aplicación con fines educativos, diseñada para apoyar el aprendizaje y la organización personal del usuario. " +
                                    "El uso de la aplicación debe realizarse de manera responsable y respetuosa. " +
                                    "Las notas, imágenes y apuntes creados dentro de la aplicación son responsabilidad del usuario. " +
                                    "La información generada puede almacenarse de forma local en el dispositivo para permitir su acceso posterior. " +
                                    "La aplicación puede recibir actualizaciones o cambios con el fin de mejorar su funcionamiento y la experiencia de uso. "
                    )
                }
            }
        )
    }
}
