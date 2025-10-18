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
            opciones = listOf("duoc", "DUOC", "Duoc", "Error de null"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "En normalización de BD, la 1FN exige:",
            opciones = listOf("Sin dependencia transitiva", " Atributos atómicos (sin multivalores/duplicados por celda)", "Clave foránea obligatoria", "Índices en todas las columnas"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "En JavaScript, ¿qué hace?\n" +
                    "\n" +
                    "<button onclick=\"alert('Hola')\">Click</button>\n",
            opciones = listOf("Lanza error en HTML", "Muestra “Hola” al cargar la página", "Muestra “Hola” al hacer click", "Cierra la pestaña"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "En Android/Kotlin, ¿qué hace esto?\n" +
                    "\n" +
                    "val suma = 2 + 3",
            opciones = listOf(" Declara función", "Crea variable inmutable con valor 5", "Crea variable mutable con valor 5", "Suma strings"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "En SQL, ¿qué hace un JOIN?",
            opciones = listOf("Duplica datos", " Combina filas de tablas según una condición relacionada", "Elimina tablas", "Crea índices automáticos"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "En estadística descriptiva, la mediana es:",
            opciones = listOf("El promedio aritmético", "El valor que más se repite", "El valor central al ordenar los datos", "La suma de todos los valores"),
            indiceCorrecto = 2
        ),

    )
}
