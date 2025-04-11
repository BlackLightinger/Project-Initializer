package org.locker.start_android.presentation.compose.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.locker.start_android.presentation.compose.common.StartAndroidNavHost
import org.locker.start_android.presentation.compose.panes.dependencies.pane.DependenciesPane
import org.locker.start_android.presentation.compose.panes.files_viewer.FilesViewerPane

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    StartAndroidNavHost(
        navController = navHostController,
        startDestination = Pane.Dependencies.name,
        modifier = modifier,
    ) {
        composable(Pane.Dependencies.name) {
            DependenciesPane(
                modifier = Modifier.fillMaxSize(),
            )
        }

        composable(Pane.FilesViewer.name) {
            FilesViewerPane(
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
