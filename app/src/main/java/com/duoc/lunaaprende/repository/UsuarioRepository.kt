package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.model.Usuario
import com.duoc.lunaaprende.model.UsuarioDao

class UsuarioRepository(private val dao: UsuarioDao) {

    suspend fun getAll(): List<Usuario> = dao.getAll()

    suspend fun insert(usuario: Usuario) = dao.insert(usuario)
    suspend fun validar(correo: String, pass: String): Boolean =
        dao.findByCorreoAndPass(correo.trim().lowercase(), pass) != null
}
