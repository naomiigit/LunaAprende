package com.duoc.lunaaprende.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.viewmodel.AuthViewModel
import com.duoc.lunaaprende.viewmodel.InicioViewModel
import com.duoc.lunaaprende.viewmodel.LoginState

@Composable
fun Inicio(inicioVm: InicioViewModel, navController: NavHostController) {

    val authVm: AuthViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val loginState by authVm.loginState.collectAsState()

    var ver by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logosinfondo),
            contentDescription = "Iniciar sesion",
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Fit
        )

        OutlinedTextField(
            value = inicioVm.inicio.correo,
            onValueChange = { inicioVm.inicio.correo = it },
            label = { Text("Ingresa tu correo duoc") },
            isError = !inicioVm.verificarCorreo(),
            supportingText = {
                Text(inicioVm.mensajesError.correo, color = androidx.compose.ui.graphics.Color.Red)
            }
        )

        OutlinedTextField(
            value = inicioVm.inicio.pass,
            onValueChange = { inicioVm.inicio.pass = it },
            label = { Text("Ingresa tu contraseña") },
            visualTransformation = if (ver) VisualTransformation.None else PasswordVisualTransformation(),
            isError = !inicioVm.verificarPass(),
            supportingText = {
                Text(inicioVm.mensajesError.pass, color = androidx.compose.ui.graphics.Color.Red)
            },
            trailingIcon = {
                TextButton(onClick = { ver = !ver }) {
                    Text(if (ver) "Ocultar" else "Ver")
                }
            }
        )

        Button(
            enabled = inicioVm.verificarInicio() && loginState !is LoginState.Loading,
            onClick = {
                authVm.login(
                    inicioVm.inicio.correo.trim().lowercase(),
                    inicioVm.inicio.pass
                )
            }
        ) {
            Text(if (loginState is LoginState.Loading) "Ingresando..." else "Continuar")
        }

        LaunchedEffect(loginState) {
            if (loginState is LoginState.Success) {
                navController.navigate("Menu") {
                    popUpTo("Inicio") { inclusive = true }
                    launchSingleTop = true
                }
                authVm.resetLoginState()
            }
        }

        if (loginState is LoginState.Error) {
            Spacer(Modifier.height(8.dp))
            Text(
                (loginState as LoginState.Error).message,
                color = androidx.compose.ui.graphics.Color.Red
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text("¿Aun no tienes una cuenta?")
        Button(onClick = { navController.navigate("Registro") }) {
            Text("Registrate")
        }
    }
}
