package org.locker.start_android.di

import org.koin.dsl.module
import org.locker.start_android.domain.repository.GenerateProjectRepository
import org.locker.start_android.domain.repository.IGenerateProjectRepository

val repositoryModule = module {
    factory<IGenerateProjectRepository> { GenerateProjectRepository(get()) }
}
