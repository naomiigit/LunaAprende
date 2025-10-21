package com.duoc.lunaaprende.model

import androidx.room.*

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios LIMIT 3")
    suspend fun getAll(): List<Usuario>

    @Insert
    suspend fun insert(usuario: Usuario)

    @Update
    suspend fun update(usuario: Usuario)

    @Delete
    suspend fun delete(usuario: Usuario)

    // validar inicio de sesión
    @Query("SELECT * FROM usuarios WHERE email = :email AND pass = :password LIMIT 1")
    suspend fun findByCorreoAndPass(email: String, password: String): Usuario?
}
