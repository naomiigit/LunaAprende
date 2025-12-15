package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.data.remote.RetrofitInstance
import com.duoc.lunaaprende.model.Pregunta

class QuizRepository {
    suspend fun getQuestionsByDifficulty(difficulty: String): List<Pregunta> {
        return RetrofitInstance.api.getQuestions(difficulty)
    }
}
