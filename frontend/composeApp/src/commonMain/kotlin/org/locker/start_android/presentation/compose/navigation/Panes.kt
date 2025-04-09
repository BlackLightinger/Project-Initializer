package org.locker.start_android.presentation.compose.navigation

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.dependencies
import startandroid.composeapp.generated.resources.ic_dependencies
import startandroid.composeapp.generated.resources.ic_dependencies_name
import startandroid.composeapp.generated.resources.ic_files_branch
import startandroid.composeapp.generated.resources.ic_preview_name
import startandroid.composeapp.generated.resources.preview

sealed class Pane(
    val name: String,
    val textStringResource: StringResource,
    val iconDrawable: DrawableResource,
    val contentDescriptionStringResource: StringResource
) {
    data object Dependencies : Pane(
        name = "DependenciesNavPane",
        textStringResource = Res.string.dependencies,
        iconDrawable = Res.drawable.ic_dependencies,
        contentDescriptionStringResource = Res.string.ic_dependencies_name
    )

    data object FilesViewer : Pane(
        name = "FilesViewerNavPane",
        textStringResource = Res.string.preview,
        iconDrawable = Res.drawable.ic_files_branch,
        contentDescriptionStringResource = Res.string.ic_preview_name
    )

    companion object {
        val NAV_PANES: List<Pane> = listOf(
            Dependencies,
            FilesViewer
        )
    }
}
