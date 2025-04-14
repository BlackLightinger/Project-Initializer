package com.example.di

import org.koin.dsl.module
import com.example.datasource.local.service.IAndoidProjectService
import com.example.datasource.local.service.AndroidProjectService
import com.example.datasource.remote.service.GitlabService
import com.example.datasource.remote.service.IGitlabService
import io.ktor.client.HttpClient
import org.koin.core.scope.get

val serviceModule = module {
    single<IAndoidProjectService> { AndroidProjectService() }
    single<IGitlabService> { GitlabService(get()) }
}
