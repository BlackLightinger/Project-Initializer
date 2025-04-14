package com.example.domain.model

data class GitlabAuth(
    val username: String,
    val password: String,
    val grantType: String,
    val gitlabHost: String
)
