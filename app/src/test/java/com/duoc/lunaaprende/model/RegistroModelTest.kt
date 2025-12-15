package com.duoc.lunaaprende.model

import org.junit.Assert.assertEquals
import org.junit.Test

class RegistroModelTest {

    //Verificar que el modelo guarda y devuelve los datos correctamente
    @Test
    fun `RegistroModel asigna y obtiene datos correctamente`() {
        // 1. Preparar los datos: Creamos una instancia del modelo
        val registroModel = RegistroModel()

        // 2. Ejecutar la acción: Asignamos valores a las propiedades
        registroModel.nombre = "Luna"
        registroModel.correo = "luna.cat@duoc.cl"
        registroModel.edad = "2"
        registroModel.pass = "Gatito123"
        registroModel.terminos = true

        // 3. Comprobar los resultados: Verificamos que cada propiedad tiene el valor esperado
        assertEquals("Luna", registroModel.nombre)
        assertEquals("luna.cat@duoc.cl", registroModel.correo)
        assertEquals("2", registroModel.edad)
        assertEquals("Gatito123", registroModel.pass)
        assertEquals(true, registroModel.terminos)
    }
}