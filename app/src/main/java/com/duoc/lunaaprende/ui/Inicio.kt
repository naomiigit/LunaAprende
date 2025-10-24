package com.duoc.lunaaprende.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.viewmodel.InicioViewModel
import com.duoc.lunaaprende.viewmodel.UsuarioViewModel

@Composable
fun Inicio(inicioVm: InicioViewModel, navController: NavHostController) {
    val userVm: UsuarioViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val loginOk by userVm.loginOk.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logosinfondo),
            contentDescription = "Iniciar sesion ",
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Fit
        )
        //validacion del correo y mensaje de error
        OutlinedTextField(
            value = inicioVm.inicio.correo,
            onValueChange = { inicioVm.inicio.correo = it },
            label = { Text("Ingresa tu correo duoc") },
            isError = !inicioVm.verificarCorreo(),
            supportingText = { Text(inicioVm.mensajesError.correo, color = androidx.compose.ui.graphics.Color.Red) }
        )


        //agregamos ver y ocultar para la contraseña
        var ver by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = inicioVm.inicio.pass,
            onValueChange = { inicioVm.inicio.pass = it },
            label = { Text("Ingresa tu contraseña") },
            visualTransformation = if (ver) VisualTransformation.None else PasswordVisualTransformation(),
            isError = !inicioVm.verificarPass(),
            supportingText = {
                Text(
                    inicioVm.mensajesError.pass,
                    color = androidx.compose.ui.graphics.Color.Red
                )
            },
            trailingIcon = {
                TextButton(onClick = { ver = !ver }) {
                    Text(if (ver) "Ocultar" else "Ver")
                }
            }
        )

        //se habilita solo si las validaciones estan ok
        Button(
            onClick = {
                userVm.validar(
                    inicioVm.inicio.correo.trim().lowercase(),
                    inicioVm.inicio.pass
                )
            },
            enabled = inicioVm.verificarInicio()
        ) {
            Text("Continuar")
        }

        LaunchedEffect(loginOk) {
            if (loginOk == true) {
                navController.navigate("Menu") {
                    popUpTo("Inicio") { inclusive = true }
                    launchSingleTop = true
                }
            }
        }

        //si sale invalido mostramos un mensaje de error
        if (loginOk == false) {
            Spacer(Modifier.height(8.dp))
            Text("Correo o contraseña inválidos", color = androidx.compose.ui.graphics.Color.Red)
        }

        //aqui vamos a la pantalla registro xd
        Spacer(modifier = Modifier.height(30.dp))
        Text("¿Aun no tienes una cuenta?")
        Button(onClick = { navController.navigate("Registro") }) {
            Text("Registrate")
        }
    }
}
