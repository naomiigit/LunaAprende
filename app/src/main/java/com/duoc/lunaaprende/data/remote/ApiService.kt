package com.duoc.lunaaprende.data.remote

import com.duoc.lunaaprende.model.Pregunta
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val authToken: String)

data class RegisterRequest(val name: String, val email: String, val password: String)
data class RegisterResponse(val authToken: String)

interface ApiService {

    @GET("question")
    suspend fun getQuestions(@Query("difficulty") difficulty: String): List<Pregunta>


    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("auth/signup")
    suspend fun register(@Body request: RegisterRequest): RegisterResponse
}