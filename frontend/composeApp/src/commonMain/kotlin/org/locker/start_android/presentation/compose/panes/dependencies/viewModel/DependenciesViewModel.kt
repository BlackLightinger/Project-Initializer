package org.locker.start_android.presentation.compose.panes.dependencies.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.locker.start_android.presentation.mapper.toCategoryType
import org.locker.start_android.presentation.model.DependencyType
import org.locker.start_android.presentation.model.DependencyViewData

class DependenciesViewModel : ViewModel() {
    private val dependencies: List<DependencyViewData> = listOf(
        DependencyViewData(DependencyType.PLUGIN, "Serialization"),
        DependencyViewData(DependencyType.LIBRARY, "Constraint layout")
    )

    private val dependenciesFlow: StateFlow<List<DependencyViewData>> =
        MutableStateFlow(dependencies)

    private val _addedDependencies: MutableStateFlow<List<DependencyViewData>> =
        MutableStateFlow(emptyList())
    val addedDependencies: StateFlow<List<DependencyViewData>> = _addedDependencies

    private val _searchValue: MutableStateFlow<String> = MutableStateFlow("")
    val searchValue: StateFlow<String> = _searchValue

    private val _searchCategory: MutableStateFlow<String?> = MutableStateFlow(null)
    val searchCategory: StateFlow<String?> = _searchCategory

    val dependenciesToShow: StateFlow<List<DependencyViewData>> =
        dependenciesFlow.combine(searchValue) { dependencies, search ->
            dependencies.filter {
                it.name.lowercase().startsWith(search.lowercase())
            }
        }.combine(searchCategory) { dependencies, category ->
            when (val cat = category?.toCategoryType()) {
                null -> dependencies
                else -> dependencies.filter { it.type == cat }
            }
        }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun onSearchValueChanged(value: String) {
        _searchValue.value = value
    }

    fun onSearchCategoryChanged(value: String?) {
        _searchCategory.value = value
    }

    fun onDependencyClick(dependency: DependencyViewData) {
        val added = addedDependencies.value
        val newList =
            if (dependency !in added) added + dependency else added.filter { it != dependency }

        println(newList)
        _addedDependencies.value = newList
    }

    fun loadDependencies() {
        viewModelScope.launch {

        }
    }
}
