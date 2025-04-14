package com.example.datasource.remote.service


import com.example.datasource.remote.model.*
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.request.headers
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json


class GitlabService(private val client: HttpClient) : IGitlabService {
    override suspend fun getToken(gitlabHost: String, authData: AuthDto): TokenDto? {
        val response = client.post("$gitlabHost$OAUTH_ENDPOINT") {
            contentType(Json)
            setBody(authData)
        }

        return if (response.status == HttpStatusCode.OK) response.body<TokenDto>() else null
    }

    override suspend fun getGroups(gitlabHost: String, token: String): GroupsListDto? {
        val gitlabUrl = "$gitlabHost$GROUPS_ENDPOINT"
        val response = client.get(gitlabUrl) {
            headers {
                append(AUTH_HEADER, "$BEARER_HEADER $token")
            }
        }

        return if (response.status == HttpStatusCode.OK) GroupsListDto(response.body<List<GroupDto>>()) else null
    }

    override suspend fun initializeRepository(
        gitlabHost: String, token: String, repositoryConfig: RepositoryDto
    ): ProjectInfoDto? {
        val gitlabUrl = "$gitlabHost$PROJECT_ENDPOINT"
        val response = client.post(gitlabUrl) {
            headers {
                append(AUTH_HEADER, "$BEARER_HEADER $token")
            }
            contentType(Json)
            setBody(repositoryConfig)
        }

        return if (response.status == HttpStatusCode.Created) response.body<ProjectInfoDto>() else null
    }

    override suspend fun pushProject(
        gitlabHost: String, token: String, pushConfig: PushDto
    ): Boolean {
        val gitlabUrl = "$gitlabHost$PROJECT_ENDPOINT/${pushConfig.projectId}${PUSH_ENDPOINT}"
        val response = client.post(gitlabUrl) {
            headers {
                append(AUTH_HEADER, "$BEARER_HEADER $token")
            }
            contentType(Json)
            setBody(pushConfig)
        }

        return response.status == HttpStatusCode.Created
    }

    private companion object {
        const val PUSH_ENDPOINT = "/repository/commits"
        const val PROJECT_ENDPOINT = "/projects"
        const val GROUPS_ENDPOINT = "/groups"
        const val OAUTH_ENDPOINT = "/oauth/token"
        const val AUTH_HEADER = "Authorization"
        const val BEARER_HEADER = "Bearer"
    }

}