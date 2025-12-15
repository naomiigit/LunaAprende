package com.duoc.lunaaprende.ui

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.duoc.lunaaprende.R
import com.duoc.lunaaprende.data.local.AppDatabase

@Composable
fun MisApuntes(navController: NavController) {
    val context = LocalContext.current
    val db = AppDatabase.getDatabase(context)

    var lista by remember { mutableStateOf(db.apunteDao().obtenerTodos()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.lunaverapunte),
            contentDescription = "Ver apuntes",
            modifier = Modifier.size(140.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Mis apuntes",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Si está vacío
        if (lista.isEmpty()) {
            Text("Aún no tienes apuntes guardados.")
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Lista de apuntes (READ)
        lista.forEach { apunte ->
            val bmp = BitmapFactory.decodeFile(apunte.rutaImagen)

            if (bmp != null) {
                Image(
                    bitmap = bmp.asImageBitmap(),
                    contentDescription = "Apunte",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Text("No se pudo cargar este apunte.")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Eliminar (DELETE)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Button(onClick = {
                    db.apunteDao().eliminar(apunte.id)
                    lista = db.apunteDao().obtenerTodos()
                }) {
                    Text("Eliminar")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }
}