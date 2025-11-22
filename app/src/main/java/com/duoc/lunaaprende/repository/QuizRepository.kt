package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.model.Pregunta
import com.duoc.lunaaprende.data.remote.RetrofitInstance

class QuizRepository {

    suspend fun getPreguntas(): List<Pregunta> {
        return RetrofitInstance.api.getQuestions()
    }
}
