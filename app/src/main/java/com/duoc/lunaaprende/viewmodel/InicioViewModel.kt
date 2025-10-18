package com.duoc.lunaaprende.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.duoc.lunaaprende.model.InicioModel
import com.duoc.lunaaprende.model.MensajesError
import com.duoc.lunaaprende.repository.InicioRepository


class InicioViewModel : ViewModel(){
    private val repository = InicioRepository()

    var inicio: InicioModel by mutableStateOf(repository.getInicio())
    var mensajesError: MensajesError by mutableStateOf(repository.getMensajesError())

    fun verificarInicio(): Boolean {
        return verificarCorreo() &&
                verificarPass()
    }

    fun verificarCorreo(): Boolean {
        return if (repository.validacionCorreo()) {
            mensajesError.correo = ""
            true
        } else {
            mensajesError.correo = ""
            false
        }
    }


    fun verificarPass(): Boolean {
        return if (repository.validacionPass()) {
            mensajesError.pass = ""
            true
        } else {
            mensajesError.pass = ""
            false
        }
    }

}
