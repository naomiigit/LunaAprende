package com.duoc.lunaaprende.model

import androidx.room.Database
import androidx.room.RoomDatabase

//aqui tenemos nuestra base de datos donde definimos entidades y data acceso object
@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
}
