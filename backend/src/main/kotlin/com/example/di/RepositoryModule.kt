package com.example.di

import com.example.domain.repository.*
import org.koin.dsl.module


val repositoryModule = module {
    factory<IAndroidProjectRepository> { AndroidProjectRepository(get()) }
    factory<IGitlabRepository> { GitlabRepository(get()) }
}
