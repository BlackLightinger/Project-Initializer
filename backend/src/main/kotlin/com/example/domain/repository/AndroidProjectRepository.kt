package com.example.domain.repository

import com.example.datasource.local.service.IAndoidProjectService
import com.example.datasource.mapper.toDomain
import com.example.datasource.mapper.toDto
import com.example.domain.model.FilePath
import com.example.domain.model.ProjectConfig
import com.example.domain.model.ProjectFilesInfo
import java.util.UUID

class AndroidProjectRepository(private val service: IAndoidProjectService) :
    IAndroidProjectRepository {
    override fun createNewProject(projectConfig: ProjectConfig): UUID {
        val uuid = service.getNewTemplateProject()
        service.setLibsVersionsConfig(uuid, projectConfig.libsVersions.toDto())
        service.setBuildSrcConfig(uuid, projectConfig.buildSrc.toDto())
        return uuid
    }

    override fun downloadProject(uuid: UUID, projectName: String): FilePath? =
        service.createZipByUuid(uuid, projectName)?.toDomain()

    override fun getProjectFiles(uuid: UUID): ProjectFilesInfo? =
        service.getProjectFiles(uuid)?.toDomain()

}