package org.locker.start_android.domain.repository

import org.locker.start_android.domain.model.GenerateProject

interface IGenerateProjectRepository {
    suspend fun download(projectInfo: GenerateProject)
}
