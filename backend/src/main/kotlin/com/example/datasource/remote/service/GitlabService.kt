package com.example.datasource.remote.service


import com.example.datasource.remote.model.*
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.request.headers
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json

import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.engine.cio.CIO
import io.ktor.client.statement.*


class GitlabService(private val client: HttpClient) : IGitlabService {
    override suspend fun getToken(gitlabHost: String, authData: AuthDto): TokenDto {
        val response = client.post("$gitlabHost$oauthEndpoint") {
            contentType(Json)
            setBody(authData)
        }.body<TokenDto>()

        return response
    }

    override suspend fun getGroups(gitlabHost: String, token: String): GroupsListDto {
        val gitlabUrl = "$gitlabHost$getGroupsEndpoint"
        val response = client.get(gitlabUrl) {
            headers {
                append("Authorization", "Bearer $token")
            }
        }.body<List<GroupDto>>()

        return GroupsListDto(response)
    }

    override suspend fun initializeRepository(
        gitlabHost: String,
        token: String,
        repositoryConfig: RepositoryDto
    ): Boolean {
        val gitlabUrl = "$gitlabHost$initProjectEndpoint"
        val response = client.post(gitlabUrl) {
            headers {
                append("Authorization", "Bearer $token")
            }
            contentType(Json)
            setBody(repositoryConfig)
        }

        return response.status == HttpStatusCode.Created
    }

    override suspend fun pushProject(
        gitlabHost: String,
        token: String,
        pushConfig: PushDto
    ): Boolean {
        val gitlabUrl = "$gitlabHost/${pushConfig.id}${pushEndpoint}${pushConfig.filePath}"
        val response = client.post(gitlabUrl) {
            headers {
                append("Authorization", "Bearer $token")
            }
            contentType(Json)
            setBody(PushDto)
        }

        return response.status == HttpStatusCode.Created
    }

    private companion object {
        const val pushEndpoint = "/repository/files/"
        const val initProjectEndpoint = "/projects"
        const val getGroupsEndpoint = "/groups"
        const val oauthEndpoint = "/oauth/token"
    }

}

//suspend fun main() {
//    val client = HttpClient(CIO) {
//        install(ContentNegotiation) {
//            json(Json {
//                ignoreUnknownKeys = true
//            })
//        }
//    }
//    val service = GitlabService(client)
//    val host = "https://gitlab.com"
//    val auth = AuthDto(
//        "",
//        "",
//        "password"
//    )
//    val token = service.getToken(host, auth)
//    println(token)
//    val grouphost = "https://gitlab.com/api/v4"
//    val groups = service.getGroups(grouphost, token.accessToken)
//    println(groups)
//}
