package com.example.datasource.mapper

import com.example.datasource.local.model.*
import com.example.domain.model.*


fun BuildSrc.toDto(): BuildSrcDto = BuildSrcDto(
    sourceCompatibility,
    targetCompatibility,
    targetSdk,
    minSdk,
    compileSdk,
    versionCode,
    versionName,
    applicationId,
    testInstrumentationRunner,
    dataBindingState,
    viewBindingState,
    jvmTarget
)

fun LibsVersions.toDto(): LibsVersionsDto = LibsVersionsDto(
    gradleVersion,
    kotlinPluginVersion,
    coreKtxVersion,
    appcompatVersion,
    materialVersion,
    constraintLayoutVersion,
    junitVersion,
    extJunitVersion,
    esspressoCoreVersion
)

fun FilePathDto.toDomain(): FilePath = FilePath(filePath)

fun ProjectFilesInfoDto.toDomain(): ProjectFilesInfo =
    ProjectFilesInfo(rootDir, files.map { file -> file.toDomain() })
