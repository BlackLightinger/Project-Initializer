package com.example.route.route

import com.example.domain.repository.IAndroidProjectRepository
import com.example.route.mapper.toDomain
import com.example.route.mapper.toUUID
import com.example.route.mapper.toRoute
import com.example.route.model.AndroidParametersRouteModel
import com.example.route.model.ProjectInfoRouteModel
import io.ktor.http.ContentDisposition
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.header
import io.ktor.server.response.respond
import io.ktor.server.response.respondFile
import org.koin.ktor.ext.inject
import java.io.File


private const val GENERATE_PROJECT_ENDPOINT = "/generate"
private const val DOWNLOAD_ENDPOINT = "/download"
private const val APP_NAME = "app.zip"


fun Route.generateAndroidProject() {
    val rep by inject<IAndroidProjectRepository>()
    get(GENERATE_PROJECT_ENDPOINT) {
        val projectConfig = call.receive<AndroidParametersRouteModel>()
        val uuid = rep.createNewProject(projectConfig.toDomain())
        call.respond(HttpStatusCode.OK, uuid.toRoute())
    }
}

fun Route.downloadProject() {
    val rep by inject<IAndroidProjectRepository>()
    get(DOWNLOAD_ENDPOINT) {
        val projectInfo = call.receive<ProjectInfoRouteModel>()
        val filePathModel =
            rep.downloadProject(projectInfo.toUUID(), projectInfo.projectName) ?: run {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }

        val file = File(filePathModel.filePath)
        call.response.header(
            HttpHeaders.ContentDisposition,
            ContentDisposition.Attachment.withParameter(
                ContentDisposition.Parameters.FileName,
                APP_NAME
            ).toString()
        )
        call.response.status(HttpStatusCode.OK)
        call.respondFile(file)
    }
}
