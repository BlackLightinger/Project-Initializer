package com.example.datasource.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class PushDto(
    val branchName: String,
    val commitMessage: String,
    val content: String,
    val filePath: String,
    val id: Int
)