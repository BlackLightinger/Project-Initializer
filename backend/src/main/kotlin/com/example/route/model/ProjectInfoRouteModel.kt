package com.example.route.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


private const val PROJECT_NAME = "app"

@Serializable
data class ProjectInfoRouteModel(
    @SerialName("uuid")
    val uuid: String,
    @SerialName("project_name")
    @EncodeDefault val projectName: String = PROJECT_NAME
)
