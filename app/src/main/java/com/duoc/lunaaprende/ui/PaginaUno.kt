package com.duoc.lunaaprende.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.duoc.lunaaprende.R

@Composable
fun PaginaUno(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Página Bienvenida")
        Text("Lunita te enseña")
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Imagen de Lunita",
            contentScale = ContentScale.Crop
        )
        Button(onClick = { navController.navigate("paginaDos") }) {
            Text("Ir a la página 2")
        }
    }
}