package com.example.datasource.local.model

data class ProjectFilesInfoDto(
    val rootDir: String,
    val files: List<FilePathDto>
)
