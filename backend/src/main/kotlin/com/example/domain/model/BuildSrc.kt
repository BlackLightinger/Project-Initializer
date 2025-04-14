package com.example.domain.model

data class BuildSrc(
    val sourceCompatibility: String,
    val targetCompatibility: String,

    val targetSdk: Int,
    val minSdk: Int,
    val compileSdk: Int,
    val versionCode: Int,
    val versionName: String,
    val applicationId: String,
    val testInstrumentationRunner: String,

    val dataBindingState: Boolean,
    val viewBindingState: Boolean,

    val jvmTarget: String
)
