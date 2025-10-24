package com.duoc.lunaaprende.model

import androidx.room.*

@Dao
interface UsuarioDao {
    // Trae todos los usuarios
    @Query("SELECT * FROM usuarios")
    suspend fun getAll(): List<Usuario>

    @Insert
    suspend fun insert(usuario: Usuario)

    @Update
    suspend fun update(usuario: Usuario)

    @Delete
    suspend fun delete(usuario: Usuario)

    //validamos inicio de sesion
    @Query("SELECT * FROM usuarios WHERE email = :email AND pass = :password LIMIT 1")
    suspend fun findByCorreoAndPass(email: String, password: String): Usuario?
}
