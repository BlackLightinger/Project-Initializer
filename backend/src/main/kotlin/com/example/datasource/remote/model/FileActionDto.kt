package com.example.datasource.remote.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val ACTION = "create"

@Serializable
data class FileActionDto(
    @SerialName("action")
    @EncodeDefault val action: String = ACTION,
    @SerialName("file_path")
    val dstFilePath: String,
    @SerialName("content")
    val content: String,
    @SerialName("encoding")
    val encoding: String
)
