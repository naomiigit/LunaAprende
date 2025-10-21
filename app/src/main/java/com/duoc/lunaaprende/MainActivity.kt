package com.duoc.lunaaprende


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.duoc.lunaaprende.model.AppDatabase
import com.duoc.lunaaprende.repository.UsuarioRepository
import com.duoc.lunaaprende.ui.Navegacion

import com.duoc.lunaaprende.ui.theme.LunaAprendeTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app.db"
        )
            .build()
        val repoUsuario = UsuarioRepository(db.usuarioDao())
        enableEdgeToEdge()
        setContent {
            LunaAprendeTheme {
                Navegacion()
            }
        }
    }
}