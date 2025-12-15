package com.duoc.lunaaprende.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.duoc.lunaaprende.R

@Composable
fun Dificultad(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Selecciona la dificultad",
            modifier = Modifier.padding(top = 30.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(8.dp))

        Image(
            painter = painterResource(id = R.drawable.lunadificultad),
            contentDescription = "Dificultad",
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(Modifier.height(12.dp))

        Button(onClick = { navController.navigate("Quiz/Facil") }) {
            Text("Facil")
        }

        Spacer(Modifier.height(12.dp))

        Button(onClick = { navController.navigate("Quiz/Medio") }) {
            Text("Medio")
        }

        Spacer(Modifier.height(12.dp))

        Button(onClick = { navController.navigate("Quiz/Dificil") }) {
            Text("Dificil")
        }

        Spacer(Modifier.height(12.dp))

        Button(onClick = { navController.navigate("Quiz/Insano") }) {
            Text("Insano")
        }

        Spacer(Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Volver al Menú")
        }
    }
}