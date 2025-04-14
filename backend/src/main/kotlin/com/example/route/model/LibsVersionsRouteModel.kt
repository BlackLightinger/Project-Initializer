package com.example.route.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


private const val GRADLE_VERSION = "7.4.2"
private const val KOTLIN_VERSION = "1.7.10"
private const val CORE_KTX_VERSION = "1.7.0"
private const val APPCOMPAT_VERSION = "1.6.1"
private const val MATERIAL_VERSION = "1.9.0"
private const val CONSTRAINT_LAYOUT_VERSION = "2.0.4"
private const val JUNIT_VERSION = "4.13.2"
private const val EXT_JUNIT_VERSION = "1.1.5"
private const val ESSPRESSO_VERSION = "3.5.1"


@Serializable
data class LibsVersionsRouteModel(
    @SerialName("gradle")
    @EncodeDefault val gradleVersion: String = GRADLE_VERSION,
    @SerialName("kotlin")
    @EncodeDefault val kotlinPluginVersion: String = KOTLIN_VERSION,

    @SerialName("core_ktx")
    @EncodeDefault val coreKtxVersion: String = CORE_KTX_VERSION,
    @SerialName("appcompat")
    @EncodeDefault val appcompatVersion: String = APPCOMPAT_VERSION,
    @SerialName("material")
    @EncodeDefault val materialVersion: String = MATERIAL_VERSION,
    @SerialName("constraint_layout")
    @EncodeDefault val constraintLayoutVersion: String = CONSTRAINT_LAYOUT_VERSION,
    @SerialName("junit")
    @EncodeDefault val junitVersion: String = JUNIT_VERSION,
    @SerialName("ext_junit")
    @EncodeDefault val extJunitVersion: String = EXT_JUNIT_VERSION,
    @SerialName("esspresso")
    @EncodeDefault val esspressoCoreVersion: String = ESSPRESSO_VERSION
)
