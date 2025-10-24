package com.duoc.lunaaprende.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.duoc.lunaaprende.model.Pregunta
import com.duoc.lunaaprende.repository.QuizRepository


class QuizViewModel(
    private val repository: QuizRepository = QuizRepository()
) : ViewModel() {

    //preguntas
    private val banco: List<Pregunta> = repository.getPreguntas()

    //seleccion aleatoria
    private var seleccion: List<Pregunta> = emptyList()

    val totalPreguntas: Int get() = seleccion.size

    var indiceActual by mutableIntStateOf(0)
        private set

    val preguntaActual: Pregunta
        get() = seleccion[indiceActual]

    var seleccionIndex by mutableIntStateOf(-1)
        private set

    init {
        reiniciarQuiz()
    }
    //marca la alternativa elegida y devuelve true si fue la correcta
    fun seleccionar(index: Int): Boolean {
        seleccionIndex = index
        return index == preguntaActual.indiceCorrecto
    }

    //nos indica si existe una siguiente pregunta
    fun haySiguiente(): Boolean = indiceActual < totalPreguntas - 1

    //avanza a la siguiente pregunta y limpia la seleccion
    fun avanzar() {
        if (haySiguiente()) {
            indiceActual++
            seleccionIndex = -1
        }
    }

    fun reiniciarQuiz() {
        seleccion = banco.shuffled().take(minOf(3, banco.size))
        indiceActual = 0
        seleccionIndex = -1
    }
}
