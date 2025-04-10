package org.locker.start_android.datasource.mapper

import org.locker.start_android.datasource.remote.model.BuildSrcDto
import org.locker.start_android.datasource.remote.model.GenerateProjectDto
import org.locker.start_android.domain.model.BuildSrc
import org.locker.start_android.domain.model.GenerateProject

fun BuildSrc.toDto(): BuildSrcDto = BuildSrcDto(
    targetSdk = targetSdk,
    minSdk = minSdk,
    compileSdk = compileSdk,
    applicationId = applicationId
)

fun GenerateProject.toDto(): GenerateProjectDto = GenerateProjectDto(
    buildSrc = buildSrc.toDto()
)
