package com.duoc.lunaaprende.data.remote

import com.duoc.lunaaprende.model.Pregunta
import retrofit2.http.GET

interface ApiService {
    @GET("question")
    suspend fun getQuestions(): List<Pregunta>
}
