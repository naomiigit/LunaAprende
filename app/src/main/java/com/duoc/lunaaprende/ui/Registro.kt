package com.duoc.lunaaprende.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.model.Usuario
import com.duoc.lunaaprende.viewmodel.RegistroViewModel
import com.duoc.lunaaprende.viewmodel.UsuarioViewModel


@Composable
fun Registro(viewModel: RegistroViewModel, navController: NavHostController) {

    val userVm: UsuarioViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    var abrirModal by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bienvenida),
            contentDescription = "Iniciar sesion ",
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Fit
        )


        OutlinedTextField(
            value = viewModel.registro.nombre,
            onValueChange = { viewModel.registro.nombre = it },
            label = { Text("Ingresa nombre") },
            isError = !viewModel.verificarNombre(),
            supportingText = { Text( viewModel.mensajesError.nombre, color = androidx.compose.ui.graphics.Color.Red) }
        )
        OutlinedTextField(
            value = viewModel.registro.correo,
            onValueChange = { viewModel.registro.correo = it },
            label = { Text("Ingresa correo") },
            isError = !viewModel.verificarCorreo(),
            supportingText = { Text( viewModel.mensajesError.correo, color = androidx.compose.ui.graphics.Color.Red) }
        )
        OutlinedTextField(
            value = viewModel.registro.pass,
            onValueChange = { viewModel.registro.pass = it },
            label = { Text("Ingresa una contraseña") },
            isError = !viewModel.verificarPass(),
            supportingText = { Text( viewModel.mensajesError.pass, color = androidx.compose.ui.graphics.Color.Red) }
        )
        OutlinedTextField(
            value = viewModel.registro.edad,
            onValueChange = { viewModel.registro.edad = it },
            label = { Text("Ingresa edad") },
            isError = !viewModel.verificarEdad(),
            supportingText = { Text( viewModel.mensajesError.edad, color = androidx.compose.ui.graphics.Color.Red) }
        )

        Checkbox(
            checked = viewModel.registro.terminos,
            onCheckedChange = { viewModel.registro.terminos = it },
        )
        Text("Acepta los términos")

        Button(
            enabled = viewModel.verificarRegistro(),
            onClick = {
                if (viewModel.verificarRegistro()) {
                    userVm.agregarUsuario(
                        Usuario(
                            nombre = viewModel.registro.nombre,
                            email = viewModel.registro.correo,
                            pass   = viewModel.registro.pass
                        )
                    )
                    abrirModal = true
                }
            }
        ) { Text("Continuar") }

        if (abrirModal) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text("Muy bien") },
                text = { Text("Cuenta creada exitosamente") },
                confirmButton = {
                    Button(onClick = {
                        abrirModal = false
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
        Button(onClick = { navController.navigate("Inicio")}) {
            Text("Iniciar Sesion")


        }

    }
}
