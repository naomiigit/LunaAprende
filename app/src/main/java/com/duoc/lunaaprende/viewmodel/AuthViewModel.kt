package com.duoc.lunaaprende.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.lunaaprende.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val token: String) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel : ViewModel() {

    private val repo = AuthRepository()

    private val _loginState = MutableStateFlow<AuthState>(AuthState.Idle)
    val loginState: StateFlow<AuthState> = _loginState

    private val _registerState = MutableStateFlow<AuthState>(AuthState.Idle)
    val registerState: StateFlow<AuthState> = _registerState

    fun login(email: String, password: String) {
        _loginState.value = AuthState.Loading
        viewModelScope.launch {
            try {
                val res = repo.login(email, password)
                _loginState.value = AuthState.Success(res.authToken)
            } catch (e: Exception) {
                _loginState.value = AuthState.Error("Credenciales incorrectas")
            }
        }
    }

    fun register(name: String, email: String, password: String) {
        _registerState.value = AuthState.Loading
        viewModelScope.launch {
            try {
                val res = repo.register(name, email, password)
                _registerState.value = AuthState.Success(res.authToken)
            } catch (e: Exception) {
                val msg =
                    if (e.message?.contains("409") == true ||
                        e.message?.contains("duplicate") == true
                    ) {
                        "El correo ya está registrado"
                    } else {
                        "No se pudo registrar"
                    }

                _registerState.value = AuthState.Error(msg)
            }
        }
    }


    fun resetLogin() { _loginState.value = AuthState.Idle }
    fun resetRegister() { _registerState.value = AuthState.Idle }
}
