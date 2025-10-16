package com.duoc.lunaaprende.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.viewModel.InicioViewModel

@Composable
fun Inicio(viewModel: InicioViewModel, navController: NavHostController) {

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

        OutlinedTextField(
            value = viewModel.inicio.correo,
            onValueChange = { viewModel.inicio.correo = it },
            label = { Text("Ingresa tu correo duoc") },
            isError = !viewModel.verificarCorreo(),
            supportingText = { Text( viewModel.mensajesError.correo, color = androidx.compose.ui.graphics.Color.Red) }
        )
        OutlinedTextField(
            value = viewModel.inicio.pass,
            onValueChange = { viewModel.inicio.pass = it },
            label = { Text("Ingresa tu contraseña") },
            isError = !viewModel.verificarPass(),
            supportingText = { Text( viewModel.mensajesError.pass, color = androidx.compose.ui.graphics.Color.Red) }
        )

        Button(
            onClick = {
                navController.navigate("Menu")
            },
            enabled = viewModel.verificarInicio()
        ) {
            Text("Continuar")
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text("¿Aun no tienes una cuenta?")
        Button(onClick = { navController.navigate("Registro")}) {
            Text("Registrate")


        }



    }
}