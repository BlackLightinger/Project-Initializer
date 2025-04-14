package com.example.datasource.remote.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val INIT_README: Boolean = true

@Serializable
data class RepositoryDto(
    @SerialName("name")
    val repositoryName: String,
    @SerialName("namespace_id")
    val groupId: Int?,
    @SerialName("initialize_with_readme")
    @EncodeDefault val initReadme: Boolean = INIT_README,
    @SerialName("default_branch")
    val branchName: String
)