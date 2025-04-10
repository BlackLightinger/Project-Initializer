package org.locker.start_android.domain.repository

import org.locker.start_android.datasource.mapper.toDto
import org.locker.start_android.datasource.remote.model.ProjectInfoDto
import org.locker.start_android.datasource.remote.service.IGenerateProjectService
import org.locker.start_android.domain.model.GenerateProject

class GenerateProjectRepository(
    private val service: IGenerateProjectService
) : IGenerateProjectRepository {

    override suspend fun download(projectInfo: GenerateProject) {
        val uuid = service.generate(projectInfo.toDto()) ?: return

        service.download(
            ProjectInfoDto(
                uuid = uuid,
                projectName = projectInfo.fileName
            )
        )
    }
}
