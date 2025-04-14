package com.example.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectInfoDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)