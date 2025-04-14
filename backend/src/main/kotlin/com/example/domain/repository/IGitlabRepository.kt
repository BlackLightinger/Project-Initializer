package com.example.domain.repository

import com.example.datasource.remote.model.FileActionDto
import com.example.domain.model.*

interface IGitlabRepository {
    suspend fun gitlabAuth(authConfig: GitlabAuth): Token
    suspend fun createGitlabProject(
        token: String,
        repositoryConfig: GitlabRepositoryConfig,
        files: ProjectFilesInfo
    ): Boolean

    suspend fun getGroups(token: String, gitlabHost: String): Groups
}