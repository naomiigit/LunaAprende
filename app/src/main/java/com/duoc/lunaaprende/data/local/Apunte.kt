package com.duoc.lunaaprende.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apuntes")
data class Apunte(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val rutaImagen: String,
    val fecha: Long
)