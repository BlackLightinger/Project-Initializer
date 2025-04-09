package org.locker.start_android.presentation.compose.panes.dependencies.pane

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import org.locker.start_android.presentation.compose.panes.dependencies.view.DependenciesList
import org.locker.start_android.presentation.compose.panes.dependencies.view.SearchRow
import org.locker.start_android.presentation.compose.panes.dependencies.viewModel.DependenciesViewModel


@Composable
fun DependenciesPane(
    dependenciesViewModel: DependenciesViewModel = koinInject(),
    modifier: Modifier = Modifier,
) {
    val searchValue by dependenciesViewModel.searchValue.collectAsState()
    val searchCategory by dependenciesViewModel.searchCategory.collectAsState()
    val dependencies by dependenciesViewModel.dependenciesToShow.collectAsState()
    val addedDependencies by dependenciesViewModel.addedDependencies.collectAsState()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        SearchRow(
            searchValue = searchValue,
            searchCategory = searchCategory,
            onSearchValueChanged = dependenciesViewModel::onSearchValueChanged,
            onSearchCategoryChanged = dependenciesViewModel::onSearchCategoryChanged,
            modifier = Modifier.fillMaxWidth()
        )

        DependenciesList(
            dependenciesToShow = dependencies,
            addedDependencies = addedDependencies,
            onItemClick = dependenciesViewModel::onDependencyClick,
            modifier = Modifier.weight(1f)
        )
    }
}
