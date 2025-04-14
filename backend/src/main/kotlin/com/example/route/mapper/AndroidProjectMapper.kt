package com.example.route.mapper

import com.example.domain.model.*
import com.example.route.model.*
import java.util.UUID


fun BuildSrcRouteModel.toDomain(): BuildSrc = BuildSrc(
    sourceCompatibility,
    targetCompatibility,
    targetSdk,
    minSdk,
    compileSdk,
    versionCode,
    versionName,
    applicationId,
    testInstrumentationRunner,
    dataBindingState,
    viewBindingState,
    jvmTarget
)

fun LibsVersionsRouteModel.toDomain(): LibsVersions = LibsVersions(
    gradleVersion,
    kotlinPluginVersion,
    coreKtxVersion,
    appcompatVersion,
    materialVersion,
    constraintLayoutVersion,
    junitVersion,
    extJunitVersion,
    esspressoCoreVersion
)

fun AndroidParametersRouteModel.toDomain(): ProjectConfig =
    ProjectConfig(buildSrc.toDomain(), libsVersions.toDomain())

fun ProjectInfoRouteModel.toUUID(): UUID = UUID.fromString(uuid)

fun UUID.toRoute(): ProjectUuidRouteModel = ProjectUuidRouteModel(this.toString())
