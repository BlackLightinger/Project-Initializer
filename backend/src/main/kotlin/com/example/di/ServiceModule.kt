package com.example.di

import org.koin.dsl.module
import com.example.datasource.local.service.*
import com.example.datasource.remote.service.*

val serviceModule = module {
    factory<IAndoidProjectService> { AndroidProjectService() }
    factory<IGitlabService> { GitlabService(get()) }
}
