package org.locker.start_android.datasource.remote.service

import org.locker.start_android.datasource.remote.model.GenerateProjectDto
import org.locker.start_android.datasource.remote.model.ProjectInfoDto

interface IGenerateProjectService {
    suspend fun generate(project: GenerateProjectDto): String?

    suspend fun download(projectInfo: ProjectInfoDto)
}
