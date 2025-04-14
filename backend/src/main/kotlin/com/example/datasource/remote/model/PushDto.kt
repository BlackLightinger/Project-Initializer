package com.example.datasource.remote.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val COMMIT_MESSAGE = "init project"

@Serializable
data class PushDto(
    @SerialName("id")
    val projectId: Int,
    @SerialName("branch")
    val branchName: String,
    @SerialName("commit_message")
    @EncodeDefault val commitMessage: String = COMMIT_MESSAGE,
    @SerialName("actions")
    val actions: List<FileActionDto>,
)