package org.locker.start_android.presentation.compose.panes.dependencies.pane

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import org.locker.start_android.presentation.compose.panes.dependencies.viewModel.DependenciesViewModel


@Composable
fun DependenciesPane(
    dependenciesViewModel: DependenciesViewModel = koinInject(),
    modifier: Modifier = Modifier,
) {

}
