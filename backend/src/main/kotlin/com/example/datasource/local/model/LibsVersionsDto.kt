package com.example.datasource.local.model

data class LibsVersionsDto(
    val gradleVersion: String,
    val kotlinPluginVersion: String,

    val coreKtxVersion: String,
    val appcompatVersion: String,
    val materialVersion: String,
    val constraintLayoutVersion: String,
    val junitVersion: String,
    val extJunitVersion: String,
    val esspressoCoreVersion: String
)
