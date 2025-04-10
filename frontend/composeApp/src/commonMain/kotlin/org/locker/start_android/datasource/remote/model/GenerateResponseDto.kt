package org.locker.start_android.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerateResponseDto(
    @SerialName("uuid")
    val uuid: String
)
