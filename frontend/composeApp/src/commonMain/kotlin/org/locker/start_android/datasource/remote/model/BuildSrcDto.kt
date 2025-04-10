package org.locker.start_android.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuildSrcDto(
    @SerialName("target_sdk")
    val targetSdk: Int,
    @SerialName("min_sdk")
    val minSdk: Int,
    @SerialName("compile_sdk")
    val compileSdk: Int,
    @SerialName("app_id")
    val applicationId: String
)
