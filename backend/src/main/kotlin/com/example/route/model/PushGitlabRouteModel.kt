package com.example.route.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val DEFAULT_BRANCH = "develop"

@Serializable
data class PushGitlabRouteModel(
    @SerialName("token")
    val token: String,
    @SerialName("host")
    val gitlabHost: String,
    @SerialName("repository_name")
    val repositoryName: String,
    @SerialName("branch_name")
    @EncodeDefault val branchName: String = DEFAULT_BRANCH,
    @SerialName("group_id")
    @EncodeDefault val groupId: Int? = null,
    @SerialName("uuid")
    val uuid: String
)
