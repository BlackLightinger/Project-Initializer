package com.example.domain.repository

import com.example.datasource.mapper.toActionsList
import com.example.datasource.mapper.toDomain
import com.example.datasource.mapper.toDto
import com.example.datasource.remote.service.IGitlabService
import com.example.domain.model.*

class GitlabRepository(private val service: IGitlabService) : IGitlabRepository {
    override suspend fun createGitlabProject(
        token: String,
        repositoryConfig: GitlabRepositoryConfig,
        files: ProjectFilesInfo
    ): Boolean {
        val projectInfo = service.initializeRepository(
            repositoryConfig.gitlabHost,
            token,
            repositoryConfig.toDto()
        ) ?: return false

        return service.pushProject(
            repositoryConfig.gitlabHost,
            token,
            repositoryConfig.toDto(projectInfo.id, files.toActionsList())
        )
    }

    override suspend fun getGroups(token: String, gitlabHost: String): Groups? =
        service.getGroups(gitlabHost, token)?.toDomain()

    override suspend fun gitlabAuth(authConfig: GitlabAuth): Token? =
        service.getToken(authConfig.gitlabHost, authConfig.toDto())?.toDomain()
}