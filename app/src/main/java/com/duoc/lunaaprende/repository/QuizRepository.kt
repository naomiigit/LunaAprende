package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.model.Pregunta

class QuizRepository {
    fun getPrimeraPregunta(): Pregunta = Pregunta(
        texto = "¿Cuál es la respuesta correcta?",
        opciones = listOf("Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4"),
        indiceCorrecto = 1
    )
}
