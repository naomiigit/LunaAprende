package com.duoc.lunaaprende.ui

import android.Manifest
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import com.duoc.lunaaprende.R
import java.io.File

@Composable
fun SubirApunte(navController: NavController) {
    val context = LocalContext.current

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var permisoConcedido by remember { mutableStateOf(false) }

    // Lanzador de cámara (toma la foto y la guarda en imageUri)
    val takePictureLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        if (success && imageUri != null) {
            val bmp = MediaStore.Images.Media.getBitmap(
                context.contentResolver,
                imageUri
            )
            bitmap = bmp
        }
    }

    // Lanzador de permiso de camara
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        permisoConcedido = granted
        if (granted) {
            val file = File.createTempFile("foto_apunte", ".jpg", context.cacheDir)
            file.deleteOnExit()

            val uri = FileProvider.getUriForFile(
                context,
                context.packageName + ".provider",
                file
            )

            imageUri = uri
            takePictureLauncher.launch(uri)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 24.dp, end = 24.dp),  // Más centrado pero no al medio total
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Subir apunte", fontWeight = FontWeight.Bold, fontSize = 26.sp)
        Spacer(Modifier.height(8.dp))
        Text("¡Comparte tus notas con tus compañeros!")

        Spacer(Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.lunaapuntes),
            contentDescription = "Gatito con libro",
            modifier = Modifier.size(165.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(Modifier.height(26.dp))

        Button(
            onClick = { cameraPermissionLauncher.launch(Manifest.permission.CAMERA) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text(text = if (bitmap == null) "Tomar foto" else "Tomar otra foto", fontSize = 18.sp)
        }

        Spacer(Modifier.height(18.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .width(200.dp)
                .height(44.dp)
        ) {
            Text("Volver al menú", fontSize = 16.sp)
        }

        // La foto tomadala lo dejamos abajo de los botones
        if (bitmap != null) {
            Spacer(Modifier.height(32.dp))

            Image(
                bitmap = bitmap!!.asImageBitmap(),
                contentDescription = "Foto del apunte",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(12.dp))
            Text("¡Has subido tu apunte exitosamente! 📚")
        }
    }
}