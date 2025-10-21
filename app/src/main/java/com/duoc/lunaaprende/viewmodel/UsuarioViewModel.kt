package com.duoc.lunaaprende.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.duoc.lunaaprende.model.AppDatabase
import com.duoc.lunaaprende.model.Usuario
import com.duoc.lunaaprende.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UsuarioViewModel(app: Application) : AndroidViewModel(app) {

    private val db by lazy {
        Room.databaseBuilder(
            getApplication(),
            AppDatabase::class.java,
            "app_db"
        ).build()
    }

    private val repo: UsuarioRepository by lazy {
        UsuarioRepository(db.usuarioDao())
    }

    val nombre = MutableStateFlow("")
    val correo = MutableStateFlow("")
    val pass   = MutableStateFlow("")
    val edad   = MutableStateFlow("")
    val terminos = MutableStateFlow(false)

    val usuarios = MutableStateFlow<List<Usuario>>(emptyList())

    val loginOk = MutableStateFlow<Boolean?>(null)

    init { cargarUsuarios() }

    private fun cargarUsuarios() {
        viewModelScope.launch {
            usuarios.value = repo.getAll()
        }
    }

    fun agregarUsuario(u: Usuario) {
        viewModelScope.launch {
            repo.insert(u)

            nombre.value = ""; correo.value = ""; pass.value = ""
            edad.value = ""; terminos.value = false
            cargarUsuarios()
        }
    }

    fun validar(correo: String, pass: String) {
        viewModelScope.launch {
            loginOk.value = repo.validar(correo, pass)
        }
    }
}
