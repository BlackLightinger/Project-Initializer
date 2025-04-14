package com.example.datasource.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class RepositoryDto(
    val repositoryName: String,
    val branchName: String,
    val groupId: Int
)