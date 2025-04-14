package com.example.datasource.remote.service

import com.example.datasource.remote.model.*

interface IGitlabService {
    suspend fun getToken(gitlabHost: String, authData: AuthDto): TokenDto
    suspend fun getGroups(gitlabHost: String, token: String): GroupsListDto
    suspend fun initializeRepository(gitlabHost: String, token: String, repositoryConfig: RepositoryDto): Boolean
    suspend fun pushProject(gitlabHost: String,  token: String, pushConfig: PushDto): Boolean
}