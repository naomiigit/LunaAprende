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

    val pregunta: Pregunta = repository.getPrimeraPregunta()

    var seleccion by mutableIntStateOf(-1)
        private set

    fun seleccionar(index: Int): Boolean {
        seleccion = index
        return index == pregunta.indiceCorrecto
    }

}
