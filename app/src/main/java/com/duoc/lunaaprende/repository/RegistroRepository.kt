package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.model.MensajesError
import com.duoc.lunaaprende.model.RegistroModel


class  RegistroRepository {

    private var registro = RegistroModel()
    private var errores = MensajesError()

    fun getRegistro():  RegistroModel = registro
    fun getMensajesError():  MensajesError = errores



    fun validacionNombre(): Boolean {
        if(registro.nombre=="")
            return false
        else
            return true
    }

    fun validacionCorreo(): Boolean {
        if (!registro.correo.matches(Regex("^[\\w.-]+@[\\w.-]+\\.\\w+$")))
            return false
        else
            return true
    }

    fun validacionEdad(): Boolean {
        val edadInt = registro.edad.toIntOrNull()
        if (edadInt == null || edadInt < 16 || edadInt > 120)
            return false
        else
            return true
    }

    fun validacionPass(): Boolean {
        if (!registro.pass.matches(Regex("^(?=.*[A-Z]).{8,}\$")))
            return false
        else
            return true
    }


    fun validacionTerminos(): Boolean {
        if (!registro.terminos)
            return false
        else
            return true
    }


}