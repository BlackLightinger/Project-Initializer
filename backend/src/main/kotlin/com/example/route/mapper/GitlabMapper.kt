package com.example.route.mapper

import com.example.domain.model.*
import com.example.route.model.*
import java.util.UUID

fun Token.toRoute(): TokenRouteModel = TokenRouteModel(accessToken)

fun AuthRouteModel.toDomain(): GitlabAuth = GitlabAuth(username, password, grantType, gitlabHost)

fun Group.toRoute(): GroupRouteModel = GroupRouteModel(id, name, path)

fun Groups.toRoute(): GroupListRouteModel =
    GroupListRouteModel(groupsList.map { group -> group.toRoute() })

fun PushGitlabRouteModel.toDomain(): GitlabRepositoryConfig =
    GitlabRepositoryConfig(gitlabHost, repositoryName, branchName, groupId)

fun PushGitlabRouteModel.toUUID(): UUID = UUID.fromString(uuid)
