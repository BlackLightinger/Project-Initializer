package com.example.plugins

import com.example.route.route.*
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        generateAndroidProject()
        downloadProject()
        authGitlab()
        getGitlabGroups()
        pushGitlab()
    }
}
