package com.duoc.lunaaprende.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.lunaaprende.model.Pregunta
import com.duoc.lunaaprende.repository.QuizRepository
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    private val repository = QuizRepository()

    // Lista con TODAS las preguntas que vienen de Xano
    private var banco: List<Pregunta> = emptyList()

    // Lista con las preguntas del quiz actual
    private var seleccion by mutableStateOf<List<Pregunta>>(emptyList())

    val totalPreguntas: Int
        get() = seleccion.size

    var indiceActual by mutableIntStateOf(0)
        private set

    val preguntaActual: Pregunta
        get() = seleccion[indiceActual]

    init {
        viewModelScope.launch {
            banco = repository.getPreguntas()
            reiniciarQuiz()
        }
    }

    fun seleccionar(index: Int): Boolean {
        val correcto = preguntaActual.correct_alternative_index - 1
        return index == correcto
    }

    fun haySiguiente(): Boolean = indiceActual < totalPreguntas - 1

    fun avanzar() {
        if (haySiguiente()) {
            indiceActual++
        }
    }

    fun reiniciarQuiz() {
        if (banco.isEmpty()) {
            seleccion = emptyList()
            indiceActual = 0
            return
        }
        seleccion = banco.shuffled().take(minOf(3, banco.size))
        indiceActual = 0
    }
}
