package com.example.datasource.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class GroupDto(
    val id: Int,
    val name: String,
    val path: String
)