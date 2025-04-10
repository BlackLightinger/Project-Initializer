package org.locker.start_android.domain.model

data class BuildSrc(
    val targetSdk: Int,
    val minSdk: Int,
    val compileSdk: Int,
    val applicationId: String
)
