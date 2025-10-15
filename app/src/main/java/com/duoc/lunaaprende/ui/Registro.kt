package com.duoc.lunaaprende.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
import com.duoc.lunaaprende.viewModel.RegistroViewModel


@Composable
fun Registro(viewModel: RegistroViewModel, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bienvenida),
            contentDescription = "bienvenida de luna",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = viewModel.registro.nombre,
            onValueChange = { viewModel.registro.nombre = it },
            label = { Text("Ingresa nombre") },
            isError = !viewModel.verificarNombre(),
            supportingText = {
                Text(
                    viewModel.mensajesError.nombre,
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        )

        OutlinedTextField(
            value = viewModel.registro.pass,
            onValueChange = { viewModel.registro.pass = it },
            label = { Text("Ingresa una contraseña") },
            isError = !viewModel.verificarPass(),
            supportingText = {
                Text(
                    viewModel.mensajesError.pass,
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        )

        OutlinedTextField(
            value = viewModel.registro.correo,
            onValueChange = { viewModel.registro.correo = it },
            label = { Text("Ingresa correo") },
            isError = !viewModel.verificarCorreo(),
            supportingText = {
                Text(
                    viewModel.mensajesError.correo,
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        )
        OutlinedTextField(
            value = viewModel.registro.edad,
            onValueChange = { viewModel.registro.edad = it },
            label = { Text("Ingresa edad") },
            isError = !viewModel.verificarEdad(),
            supportingText = {
                Text(
                    viewModel.mensajesError.edad,
                    color = androidx.compose.ui.graphics.Color.Blue
                )
            }
        )
        Checkbox(
            checked = viewModel.registro.terminos,
            onCheckedChange = { viewModel.registro.terminos = it },
        )
        Text("Acepta los términos")

        Button(onClick = {navController.navigate("Inicio")}) {
            Text("Continuar")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text("¿Ya tienes una cuenta?")
        Button(onClick = { navController.navigate("Inicio")}) {
            Text("Iniciar Sesion")
        }
    }
}
