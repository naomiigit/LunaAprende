package com.duoc.lunaaprende.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.lunaaprende.model.Pregunta
import com.duoc.lunaaprende.repository.QuizRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class QuizState {
    object Idle : QuizState()
    object Loading : QuizState()
    data class Ready(val preguntas: List<Pregunta>) : QuizState()
    object Empty : QuizState()
    data class Error(val message: String) : QuizState()
}

class QuizViewModel : ViewModel() {

    private val repo = QuizRepository()

    private var preguntas: List<Pregunta> = emptyList()
    private var indiceActualPrivado: Int = 0

    private val _state = MutableStateFlow<QuizState>(QuizState.Idle)
    val state: StateFlow<QuizState> = _state

    val totalPreguntas: Int get() = preguntas.size
    val indiceActual: Int get() = indiceActualPrivado

    val preguntaActual: Pregunta?
        get() = preguntas.getOrNull(indiceActualPrivado)

    fun cargarPreguntas(difficulty: String) {
        _state.value = QuizState.Loading
        indiceActualPrivado = 0
        preguntas = emptyList()

        viewModelScope.launch {
            try {
                val data = repo.getQuestionsByDifficulty(difficulty)

                if (data.isEmpty()) {
                    _state.value = QuizState.Empty
                    return@launch
                }

                // preguntas aleatorias
                preguntas = data.shuffled().take(minOf(5, data.size))

                _state.value = QuizState.Ready(preguntas)
            } catch (e: Exception) {
                _state.value = QuizState.Error("Error cargando preguntas: ${e.message ?: "desconocido"}")
            }
        }
    }

    fun seleccionar(indice: Int): Boolean {
        val q = preguntaActual ?: return false

        return indice == q.correct_alternative_index
    }

    fun haySiguiente(): Boolean = indiceActualPrivado < preguntas.lastIndex

    fun avanzar() {
        if (haySiguiente()) indiceActualPrivado++
    }
}
