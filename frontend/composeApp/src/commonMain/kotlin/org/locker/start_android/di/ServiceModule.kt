package org.locker.start_android.di

import org.koin.dsl.module
import org.locker.start_android.datasource.remote.service.GenerateProjectService
import org.locker.start_android.datasource.remote.service.IGenerateProjectService

val serviceModule = module {
    factory<IGenerateProjectService> { GenerateProjectService(get()) }
}
