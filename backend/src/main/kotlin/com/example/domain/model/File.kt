package com.example.domain.model

data class File(
    val filePath: String,
    val fileSize: Long,
    val fileType: String,
    val createdAt: Long
)
