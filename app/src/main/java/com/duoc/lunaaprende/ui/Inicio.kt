package com.duoc.lunaaprende.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController

import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.viewModel.InicioViewModel


@Composable
fun Inicio( viewModel: InicioViewModel, navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logosinfondo),
            contentDescription = "Iniciar sesion ",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = viewModel.inicio.correo,
            onValueChange = { viewModel.inicio.correo = it },
            label = { Text("Ingresa tu correo") },
            isError = !viewModel.verificarCorreo(),
            supportingText = {
                Text(
                    viewModel.mensajesError.correo,
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        )
        OutlinedTextField(
            value = viewModel.inicio.pass,
            onValueChange = { viewModel.inicio.pass = it },
            label = { Text("Ingresa una contraseña") },
            isError = !viewModel.verificarPass(),
            supportingText = {
                Text(
                    viewModel.mensajesError.pass,
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        )
        Button(onClick = {navController.navigate("Menu")}) {
            Text("Continuaar")
        }
    }
}