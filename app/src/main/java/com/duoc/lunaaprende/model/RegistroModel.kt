package com.duoc.lunaaprende.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class RegistroModel {
    var nombre by mutableStateOf("")
    var pass by mutableStateOf("")
    var correo by mutableStateOf("")
    var edad by mutableStateOf("")
    var terminos by mutableStateOf(false)
}