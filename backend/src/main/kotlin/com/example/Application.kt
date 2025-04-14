package com.example

import com.example.di.httpClientModule
import com.example.di.repositoryModule
import com.example.di.serviceModule
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.koin.ktor.plugin.Koin
import org.koin.ktor.plugin.koin
import org.koin.logger.slf4jLogger

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureDI()
}

fun Application.configureDI() {
    install(Koin) {
        slf4jLogger()
        modules(
            httpClientModule,
            serviceModule,
            repositoryModule
        )
    }
}
