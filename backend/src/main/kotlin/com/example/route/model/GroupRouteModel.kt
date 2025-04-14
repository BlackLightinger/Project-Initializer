package com.example.route.model

import kotlinx.serialization.Serializable

@Serializable
data class GroupRouteModel(
    val id: Int,
    val name: String,
    val path: String
)
