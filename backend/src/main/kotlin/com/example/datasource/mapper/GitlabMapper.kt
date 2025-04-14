package com.example.datasource.mapper

import com.example.datasource.remote.model.*
import com.example.domain.model.*
import java.io.File
import java.util.Base64

private const val ANDROID_APP_NAME = "AndroidApp"
private const val ENCODING_TEXT = "text"
private const val ENCODING_BASE64 = "base64"
private const val WEBP_EXTENSION = ".webp"
private const val JAR_EXTENSION = ".jar"
private const val GITLAB_FILE_SEPARATOR = '/'

fun GitlabAuth.toDto(): AuthDto = AuthDto(username, password, grantType)

fun GroupDto.toDomain(): Group = Group(id, name, path)

fun GroupsListDto.toDomain(): Groups = Groups(groupsList.map { group ->
    group.toDomain()
})

fun TokenDto.toDomain(): Token = Token(accessToken, tokenType, expiresIn)

fun GitlabRepositoryConfig.toDto(): RepositoryDto =
    RepositoryDto(repositoryName = repositoryName, groupId = groupId, branchName = branchName)

fun GitlabRepositoryConfig.toDto(projectId: Int, actions: List<FileActionDto>): PushDto =
    PushDto(projectId = projectId, actions = actions, branchName = branchName)

fun ProjectFilesInfo.toActionsList(): List<FileActionDto> {
    val actions: MutableList<FileActionDto> = mutableListOf()
    files.forEach { fileDto ->
        val localPath =
            fileDto.filePath.drop(rootDir.length).replace(File.separatorChar, GITLAB_FILE_SEPARATOR)
        val dstFilePath = "$ANDROID_APP_NAME$localPath"
        val filePath = fileDto.filePath
        actions.add(
            if (filePath.endsWith(WEBP_EXTENSION) or filePath.endsWith(JAR_EXTENSION))
                FileActionDto(
                    dstFilePath = dstFilePath,
                    content = Base64.getEncoder()
                        .encodeToString(File(fileDto.filePath).readBytes()),
                    encoding = ENCODING_BASE64
                )
            else
                FileActionDto(
                    dstFilePath = dstFilePath,
                    content = File(fileDto.filePath).readText(),
                    encoding = ENCODING_TEXT
                )
        )
    }
    return actions
}
