package com.duoc.lunaaprende.model

data class Pregunta(
    val id: Int,
    val question_text: String,
    val alternative_1: String,
    val alternative_2: String,
    val alternative_3: String,
    val alternative_4: String,
    val correct_alternative_index: Int
)