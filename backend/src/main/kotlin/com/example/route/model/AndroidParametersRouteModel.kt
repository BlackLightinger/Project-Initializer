package com.example.route.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AndroidParametersRouteModel(
    @SerialName("build_src")
    @EncodeDefault val buildSrc: BuildSrcRouteModel = BuildSrcRouteModel(),
    @SerialName("libs_versions")
    @EncodeDefault val libsVersions: LibsVersionsRouteModel = LibsVersionsRouteModel()
)
