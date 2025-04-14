package com.example.route.route

import com.example.domain.repository.IAndroidProjectRepository
import com.example.domain.repository.IGitlabRepository
import com.example.route.mapper.toDomain
import com.example.route.mapper.toRoute
import com.example.route.mapper.toUUID
import com.example.route.model.AuthRouteModel
import com.example.route.model.PushGitlabRouteModel
import com.example.route.model.RequestGroupsRouteModel
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import org.koin.ktor.ext.inject

private const val GROUPS_ENDPOINT = "/groups"
private const val AUTH_ENDPOINT = "/auth"
private const val PUSH_ENDPOINT = "/push"


fun Route.getGitlabGroups() {
    val rep by inject<IGitlabRepository>()
    get(GROUPS_ENDPOINT) {
        val groupData = call.receive<RequestGroupsRouteModel>()
        val groups = rep.getGroups(groupData.token, groupData.host) ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        call.respond(HttpStatusCode.OK, groups.toRoute())
    }
}

fun Route.authGitlab() {
    val rep by inject<IGitlabRepository>()
    get(AUTH_ENDPOINT) {
        val auth = call.receive<AuthRouteModel>()
        val token = rep.gitlabAuth(auth.toDomain()) ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        call.respond(HttpStatusCode.OK, token.toRoute())
    }
}

fun Route.pushGitlab() {
    val gitRep by inject<IGitlabRepository>()
    val androidRep by inject<IAndroidProjectRepository>()
    get(PUSH_ENDPOINT) {
        val pushConfig = call.receive<PushGitlabRouteModel>()
        val androidFiles = androidRep.getProjectFiles(pushConfig.toUUID()) ?: run {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }
        val status =
            gitRep.createGitlabProject(pushConfig.token, pushConfig.toDomain(), androidFiles)
        val statusCode = if (status) HttpStatusCode.OK else HttpStatusCode.BadRequest
        call.respond(statusCode)
    }
}
