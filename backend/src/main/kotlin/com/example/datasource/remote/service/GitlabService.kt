package com.example.datasource.remote.service


import com.example.datasource.remote.model.*
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.request.headers
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json


class GitlabService(private val client: HttpClient) : IGitlabService {
    override suspend fun getToken(gitlabHost: String, authData: AuthDto): TokenDto {
        val response = client.post("$gitlabHost$OAUTH_ENDPOINT") {
            contentType(Json)
            setBody(authData)
        }.body<TokenDto>()

        return response
    }

    override suspend fun getGroups(gitlabHost: String, token: String): GroupsListDto {
        val gitlabUrl = "$gitlabHost$GROUPS_ENDPOINT"
        val response = client.get(gitlabUrl) {
            headers {
                append(AUTH_HEADER, "$BEARER_HEADER $token")
            }
        }.body<List<GroupDto>>()

        return GroupsListDto(response)
    }

    override suspend fun initializeRepository(
        gitlabHost: String,
        token: String,
        repositoryConfig: RepositoryDto
    ): ProjectInfoDto {
        val gitlabUrl = "$gitlabHost$PROJECT_ENDPOINT"
        val response = client.post(gitlabUrl) {
            headers {
                append(AUTH_HEADER, "$BEARER_HEADER $token")
            }
            contentType(Json)
            setBody(repositoryConfig)
        }.body<ProjectInfoDto>()

        return response
    }

    override suspend fun pushProject(
        gitlabHost: String,
        token: String,
        pushConfig: PushDto
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
//        "LockeRL",
//        "",
//        "password"
//    )
//    val token = service.getToken(host, auth).also { println(it) }
//    val apihost = "https://gitlab.com/api/v4"
//    val groups = service.getGroups(apihost, token.accessToken).also { println(it) }
//
//    val rep = RepositoryDto(
//        "testApp1",
//        groups.groupsList[1].id,
//        branchName = "develop"
//    )
//    println(rep)
//    val init = service.initializeRepository(apihost, token.accessToken, rep).also { println(it) }

//    val androidService = AndroidProjectService()
//    println(UUID.fromString("cc62dc71-fb53-49cb-91d1-4fd87442e3d1"))
//    val files = androidService.getProjectFiles(UUID.fromString("cc62dc71-fb53-49cb-91d1-4fd87442e3d1"))
//
//    val actions: MutableList<FileActionDto> = mutableListOf()
//    files?.files?.forEach {
//        actions.add(
//            if (it.filePath.endsWith(".webp") or it.filePath.endsWith(".jar"))
//                FileActionDto(
//                dstFilePath = "app" + it.filePath.drop(files.rootDir.length).replace(File.separatorChar, '/'),
//                content = Base64.getEncoder().encodeToString(File(it.filePath).readBytes()),
//                    action = "create",
//                    encoding = "base64"
//                )
//        else
//                FileActionDto(
//                    dstFilePath = "app" + it.filePath.drop(files.rootDir.length).replace(File.separatorChar, '/'),
//                    content = File(it.filePath).readText(),
//                    action = "create",
//                    encoding = "text"
//                )
//        )
//    }
//
//    val pushd = PushDto(
//        projectId = init.id,
//        branchName = "develop",
//        actions = actions,
//        commitMessage = "init"
//    )
//    service.pushProject(apihost, token.accessToken, pushd)
//
//}