package com.example.datasource.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class GroupsListDto(
    val groupsList: List<GroupDto>
)