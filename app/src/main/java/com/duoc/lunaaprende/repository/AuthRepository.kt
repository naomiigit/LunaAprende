package com.duoc.lunaaprende.repository

import com.duoc.lunaaprende.data.remote.LoginRequest
import com.duoc.lunaaprende.data.remote.RegisterRequest
import com.duoc.lunaaprende.data.remote.RetrofitInstance

class AuthRepository {

    suspend fun login(email: String, password: String) =
        RetrofitInstance.api.login(LoginRequest(email, password))

    suspend fun register(name: String, email: String, password: String) =
        RetrofitInstance.api.register(RegisterRequest(name, email, password))
}
