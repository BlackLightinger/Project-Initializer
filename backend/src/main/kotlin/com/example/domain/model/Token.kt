package com.example.domain.model

data class Token(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int
)
