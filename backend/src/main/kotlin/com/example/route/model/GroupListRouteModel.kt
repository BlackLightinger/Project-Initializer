package com.example.route.model

import kotlinx.serialization.Serializable

@Serializable
data class GroupListRouteModel(val groups: List<GroupRouteModel>)
