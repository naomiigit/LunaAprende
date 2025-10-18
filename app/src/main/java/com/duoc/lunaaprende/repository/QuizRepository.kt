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
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        //----------------------------------------------------------------------//
        Pregunta(
            texto = "En una API REST, el código 404 significa:",
            opciones = listOf("Solicitud correcta", "Recurso no encontrado", "Error del servidor", "No autorizado"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "¿Qué hace este SQL?" +
                    "\n" +
                    "SELECT COUNT(*) FROM Ventas;",
            opciones = listOf("Suma los montos", "Cuenta filas de la tabla Ventas", "Cuenta columnas", "Suma columnas numéricas"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "En ingeniería de requisitos, un requisito no funcional es:",
            opciones = listOf("“El sistema debe registrar ventas”", "“El sistema debe calcular IVA”", "“La respuesta debe ser < 2 s en horario peak”", " “El usuario puede crear clientes”"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "En Git, ¿qué hace git commit -m \"msg\"?",
            opciones = listOf("Sube cambios al remoto", " Crea un commit en local con mensaje", "Descarta cambios locales", " Cambia de rama"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "¿Qué imprime este Java?\n" +
                    "\n" +
                    "String s = \"duoc\";\n" +
                    "System.out.println(s.toUpperCase());\n",
            opciones = listOf("duoc", "DUOC", "Duoc", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "¿Cuántos días tiene una semana?",
            opciones = listOf("5", "6", "7", "8"),
            indiceCorrecto = 2
        ),

    )
}
