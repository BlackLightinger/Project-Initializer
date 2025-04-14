package com.example.datasource.local.service

import com.example.datasource.local.model.*
import java.util.UUID

interface IAndoidProjectService {
    fun getProjectPathByUuid(uuid: UUID): FilePathDto?
    fun getNewTemplateProject(): UUID
    fun setBuildSrcConfig(uuid: UUID, buildSrc: BuildSrcDto)
    fun setLibsVersionsConfig(uuid: UUID, libsVersions: LibsVersionsDto)
}