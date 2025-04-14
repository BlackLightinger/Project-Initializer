package com.example.domain.repository

import com.example.domain.model.*
import java.util.UUID

interface IAndroidProjectRepository {
    fun createNewProject(projectConfig: ProjectConfig): UUID
    fun downloadProject(uuid: UUID, projectName: String): FilePath?
    fun getProjectFiles(uuid: UUID): ProjectFilesInfo?
}