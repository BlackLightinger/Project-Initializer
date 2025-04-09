package org.locker.start_android.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.locker.start_android.presentation.compose.panes.dependencies.viewModel.DependenciesViewModel
import org.locker.start_android.presentation.compose.panes.start_pane.viewmodel.MainScreenViewModel

val viewModelModule = module {
    viewModel { DependenciesViewModel() }
    viewModel { MainScreenViewModel() }
}
