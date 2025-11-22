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

    //base de datos room
    private val db by lazy {
        Room.databaseBuilder(
            getApplication(),
            AppDatabase::class.java,
            "app.db"
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

    //cargamos todos los usuarios desde el repositorio
    private fun cargarUsuarios() {
        viewModelScope.launch {
            usuarios.value = repo.getAll()
        }
    }

    //agrega un usuario en la base de datos, limpia el formulario y vuelve a cargar la lista
    fun agregarUsuario(u: Usuario) {
        viewModelScope.launch {
            repo.insert(u)

            nombre.value = ""; correo.value = ""; pass.value = ""
            edad.value = ""; terminos.value = false
            cargarUsuarios()
        }
    }

    //aca verificamos el correo y la contraseña y actualiza login
    fun validar(correo: String, pass: String) {
        viewModelScope.launch {
            loginOk.value = repo.validar(correo, pass)
        }
    }
}
