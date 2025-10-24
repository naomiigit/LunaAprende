package com.duoc.lunaaprende.repository

import android.util.Patterns
import com.duoc.lunaaprende.model.InicioModel
import com.duoc.lunaaprende.model.MensajesError

class InicioRepository {

    private var inicio = InicioModel()
    private var errores = MensajesError()

    fun getInicio(): InicioModel = inicio
    fun getMensajesError(): MensajesError = errores

    fun validacionCorreo(): Boolean {
        val c = inicio.correo.trim().lowercase()
        return Patterns.EMAIL_ADDRESS.matcher(c).matches() && c.endsWith("@duoc.cl")
    }


    fun validacionPass(): Boolean = inicio.pass.length >= 8
}
