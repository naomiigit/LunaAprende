package com.duoc.lunaaprende.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.duoc.lunaaprende.model.MensajesError
import com.duoc.lunaaprende.model.RegistroModel
import com.duoc.lunaaprende.repository.RegistroRepository




class RegistroViewModel : ViewModel() {

    private val repository = RegistroRepository()

    var registro: RegistroModel by mutableStateOf( repository.getRegistro() )
    var mensajesError: MensajesError by mutableStateOf( repository.getMensajesError() )

    // Valida el formulario completo
    fun verificarRegistro(): Boolean {
        return verificarNombre() &&
                verificarCorreo() &&
                verificarPass() &&
                verificarEdad() &&
                verificarTerminos()
    }

    fun verificarNombre(): Boolean {
        if (!repository.validacionNombre()) {
            mensajesError.nombre = "El nombre no puede estar vacío"
            return false
        } else {
            mensajesError.nombre = ""
            return true
        }
        return repository.validacionNombre()
    }

    fun verificarCorreo(): Boolean {
        if(!repository.validacionCorreo()) {
            mensajesError.correo = "El correo no es válido"
            return false
        } else {
            mensajesError.correo = ""
            return true
        }
        return repository.validacionCorreo()
    }

    fun verificarPass(): Boolean {
        if(!repository.validacionPass()) {
            mensajesError.pass = "La contraseña no es válida"
            return false
        } else {
            mensajesError.pass = ""
            return true
        }
        return repository.validacionPass()
    }

    fun verificarEdad(): Boolean {
        if(!repository.validacionEdad()) {
            mensajesError.edad = "Debes ser mayor de 16 años"
            return false
        } else {
            mensajesError.edad = ""
            return true
        }
        return repository.validacionEdad()
    }

    fun verificarTerminos(): Boolean {
        if(!repository.validacionTerminos()) {
            mensajesError.terminos = "Debes aceptar los términos"
            return false
        } else {
            mensajesError.terminos = ""
            return true
        }
        return repository.validacionTerminos()
    }




}