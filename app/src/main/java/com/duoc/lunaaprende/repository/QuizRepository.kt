package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.model.Pregunta

class QuizRepository {


    //a = 0    b =1     c =2     d =3

    fun getPreguntas(): List<Pregunta> = listOf(
        Pregunta(
            texto = "¿Qué imprime este código Java?",
            opciones = listOf("23", "5", "x + 2", "Error de compilación"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "En SQL, ¿qué hace?\n" +
                    "\n" +
                    "SELECT nombre FROM Alumno WHERE sede = 'Maipú';\n",
            opciones = listOf("Crea una tabla Alumno", "Actualiza el campo sede", "Devuelve nombres de alumnos de la sede Maipú", "Elimina alumnos de Maipú"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "En HTTP para una API REST, ¿qué método se usa típicamente para crear un recurso?",
            opciones = listOf("GET", "POST", "PUT", "DELETE"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "¿Qué representa “PaaS” en cloud?",
            opciones = listOf("Process as a Service", "Program as a Service", "Product as a Service", "Platform as a Service"),
            indiceCorrecto = 3
        ),
        Pregunta(
            texto = "¿Qué imprime este Kotlin?\n" +
                    "\n" +
                    "val list = listOf(1,2,3)\n" +
                    "println(list.first())",
            opciones = listOf("1", "0", "3", "Error por mutabilidad"),
            indiceCorrecto = 0
        ),
        Pregunta(
            texto = "En POO, la herencia permite:",
            opciones = listOf("Que un objeto tenga múltiples estados simultáneos", "Reutilizar atributos y métodos de una clase base", "Ejecución paralela de métodos", "Encriptar variables privadas"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "En HTML, ¿qué nivel de título es <h3>?",
            opciones = listOf("El más grande", "Nivel 2", "Nivel 3", "Un subtítulo sin semántica"),
            indiceCorrecto = 2
        ),
        Pregunta(
            texto = "En Java, ¿qué hace == con tipos primitivos?",
            opciones = listOf("Compara referencias", "Compara valores", "Convierte a String y compara", "Lanza excepción si difiere"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "En SQL, una clave primaria (PRIMARY KEY):",
            opciones = listOf("Acepta nulos y repite valores", "No acepta nulos y es única", "Solo acepta nulos", "Es opcionalmente única"),
            indiceCorrecto = 1
        ),
        Pregunta(
            texto = "¿Qué código Java imprime “Hola, DUOC”?",
            opciones = listOf("System.out.println(\"Hola, DUOC\");", "print(\"Hola, DUOC\")", "echo \"Hola, DUOC\";", "Console.log(\"Hola, DUOC\");"),
            indiceCorrecto = 0
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
