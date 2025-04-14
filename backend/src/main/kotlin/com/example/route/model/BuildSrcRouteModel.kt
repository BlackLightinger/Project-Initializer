package com.example.route.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val SOURCE_COMPATIBILITY = "VERSION_1_8"
private const val TARGET_COMPATIBILITY = "VERSION_1_8"
private const val TARGET_SDK = 33
private const val MIN_SDK = 24
private const val COMPILE_SDK = 33
private const val VERSION_CODE = 1
private const val VERSION_NAME = "1.0"
private const val APP_ID = "com.example.project_initializer"
private const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
private const val DATA_BINDING = true
private const val VIEW_BINDING = true
private const val JVM_TARGET = "1.8"


@Serializable
data class BuildSrcRouteModel(
    @SerialName("source_compatibility")
    @EncodeDefault val sourceCompatibility: String = SOURCE_COMPATIBILITY,
    @SerialName("target_compatibility")
    @EncodeDefault val targetCompatibility: String = TARGET_COMPATIBILITY,

    @SerialName("target_sdk")
    @EncodeDefault val targetSdk: Int = TARGET_SDK,
    @SerialName("min_sdk")
    @EncodeDefault val minSdk: Int = MIN_SDK,
    @SerialName("compile_sdk")
    @EncodeDefault val compileSdk: Int = COMPILE_SDK,
    @SerialName("version_code")
    @EncodeDefault val versionCode: Int = VERSION_CODE,
    @SerialName("version_name")
    @EncodeDefault val versionName: String = VERSION_NAME,
    @SerialName("app_id")
    @EncodeDefault val applicationId: String = APP_ID,
    @SerialName("test_runner")
    @EncodeDefault val testInstrumentationRunner: String = TEST_RUNNER,

    @SerialName("data_binding")
    @EncodeDefault val dataBindingState: Boolean = DATA_BINDING,
    @SerialName("view_binging")
    @EncodeDefault val viewBindingState: Boolean = VIEW_BINDING,

    @SerialName("jvm_target")
    @EncodeDefault val jvmTarget: String = JVM_TARGET
)
