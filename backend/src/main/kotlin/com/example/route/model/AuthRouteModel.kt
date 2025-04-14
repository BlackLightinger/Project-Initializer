package com.example.route.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val GRANT_TYPE_PASSWORD = "password"

@Serializable
data class AuthRouteModel(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
    @SerialName("grant_type")
    @EncodeDefault val grantType: String = GRANT_TYPE_PASSWORD,
    @SerialName("host")
    val gitlabHost: String
)
