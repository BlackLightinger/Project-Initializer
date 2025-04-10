package org.locker.start_android.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectInfoDto(
    @SerialName("uuid")
    val uuid: String,
    @SerialName("project_name")
    val projectName: String
)


