package com.duoc.lunaaprende.ui

import com.duoc.lunaaprende.R

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duoc.lunaaprende.data.local.Session

@Composable
fun Menu(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Menú Principal",
            modifier = Modifier.padding(top = 30.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold//letritas en negrita
        )

        Spacer(Modifier.height(8.dp))

        Image(
            painter = painterResource(id = R.drawable.lunaescoge),
            contentDescription = "Mascota",
            modifier = Modifier
                .height(370.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

        Spacer(Modifier.height(16.dp))

        //con este boton vamos a la pantalla quiz
        Button(
            onClick = { navController.navigate("Dificultad") },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) { Text("Realizar Quiz", fontSize = 18.sp) }

        Spacer(Modifier.height(12.dp))

        //y en este boton vamos a la pantalla de los apuntes
        Button(
            onClick = { navController.navigate("SubirApunte") },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) { Text("Subir Apuntes", fontSize = 18.sp) }

        //y aca volvemos a nuestro inicio de sesion
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                navController.navigate("Inicio") {
                    popUpTo("Menu") { inclusive = true }
                    launchSingleTop = true
                }
            }
        ) {
            Text("Volver a iniciar Sesion")
        }

        val session = Session(LocalContext.current)

        Button(onClick = {
            session.logout()
            navController.navigate("Inicio") {
                popUpTo("Menu") { inclusive = true }
            }
        }) {
            Text("Cerrar sesión")
        }


    }
}

