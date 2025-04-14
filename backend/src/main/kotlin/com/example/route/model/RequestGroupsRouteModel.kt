package com.example.route.model

import kotlinx.serialization.Serializable

@Serializable
data class RequestGroupsRouteModel(
    val token: String,
    val host: String
)
