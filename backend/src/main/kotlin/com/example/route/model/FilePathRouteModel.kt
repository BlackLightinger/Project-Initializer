package com.example.route.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilePathRouteModel(@SerialName("filepath") val filePath: String)
