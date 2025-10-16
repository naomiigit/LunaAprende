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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

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
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold // letra en negrita
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

        Button(
            onClick = { navController.navigate("Quiz") },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) { Text("Realizar Quiz", fontSize = 18.sp) }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate("subir_apunte") },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) { Text("Subir Apuntes", fontSize = 18.sp) }
    }
}

