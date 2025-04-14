package com.example.domain.model

data class GitlabRepository(
    val gitlabHost: String,
    val repositoryName: String,
    val branchName: String,
    val groupId: Int
)
