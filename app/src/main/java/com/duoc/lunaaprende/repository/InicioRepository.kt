package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.model.InicioModel
import com.duoc.lunaaprende.model.MensajesError


class InicioRepository {

    private val USUARIO = "usuario@duoc.cl"
    private val CLAVE   = "1234"

    private var inicio = InicioModel()
    private var errores = MensajesError()

    fun getInicio(): InicioModel = inicio
    fun getMensajesError(): MensajesError = errores

    fun validacionCorreo(): Boolean =
        inicio.correo.trim() == USUARIO

    fun validacionPass(): Boolean =
        inicio.pass == CLAVE
}