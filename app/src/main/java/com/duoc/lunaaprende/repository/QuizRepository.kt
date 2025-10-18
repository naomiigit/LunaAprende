package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.model.Pregunta

class QuizRepository {

    fun getPreguntas(): List<Pregunta> = listOf(
        Pregunta(
            texto = "¿Cuál es la respuesta correcta?",
            opciones = listOf("Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "¿Capital de Chile?",
            opciones = listOf("Valparaíso", "Santiago", "Concepción", "La Serena"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "2 + 2 = ?",
            opciones = listOf("3", "4", "5", "6"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "Color del cielo despejado (de día)",
            opciones = listOf("Rojo", "Azul", "Verde", "Amarillo"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        )
    )
}
