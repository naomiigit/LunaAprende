package com.duoc.lunaaprende.model

import androidx.room.Database
import androidx.room.RoomDatabase

// Base de datos Room principal: define entidades y DAOs
@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}
