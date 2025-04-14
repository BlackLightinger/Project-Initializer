package com.example.domain.repository

import com.example.domain.model.*

interface IGitlabRepository {
    fun gitlabAuth(authConfig: GitlabAuth): Token
    fun createGitlabProject(token: String, repositoryConfig: GitlabRepository, filePath: FilePath)
    fun getGroups(token: String, gitlabHost: String): Groups
}