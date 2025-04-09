package org.locker.start_android.presentation.mapper

import org.locker.start_android.presentation.model.DependencyType

fun String.toCategoryType(): DependencyType? = when(this) {
    "Plugins" -> DependencyType.PLUGIN
    "Libraries" -> DependencyType.LIBRARY
    else -> null
}
