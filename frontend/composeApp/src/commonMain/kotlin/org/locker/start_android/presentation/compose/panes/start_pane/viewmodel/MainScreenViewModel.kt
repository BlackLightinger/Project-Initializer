package org.locker.start_android.presentation.compose.panes.start_pane.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.locker.start_android.datasource.remote.model.BuildSrcDto
import org.locker.start_android.datasource.remote.model.GenerateProjectDto
import org.locker.start_android.datasource.remote.model.ProjectInfoDto
import org.locker.start_android.datasource.remote.service.IGenerateProjectService

class MainScreenViewModel(private val service: IGenerateProjectService) : ViewModel() {
    private val _projectArtifact: MutableStateFlow<String> =
        MutableStateFlow(DEFAULT_PROJECT_ARTIFACT)
    val projectArtifact: StateFlow<String> = _projectArtifact

    val projectFileName: StateFlow<String> =
        projectArtifact.map { it.substringAfterLast('.') + ZIP_EXTENSION }
            .stateIn(viewModelScope, SharingStarted.Eagerly, "")

    private val _minSdk: MutableStateFlow<Int> = MutableStateFlow(MIN_SDK_DEFAULT)
    val minSdk: StateFlow<Int> = _minSdk

    private val _compileSdk: MutableStateFlow<Int> = MutableStateFlow(COMPILE_SDK_DEFAULT)
    val compileSdk: StateFlow<Int> = _compileSdk

    private val _targetSdk: MutableStateFlow<Int> = MutableStateFlow(TARGET_SDK_DEFAULT)
    val targetSdk: StateFlow<Int> = _targetSdk


    fun onProjectArtifactChange(artifact: String) {
        _projectArtifact.value = artifact
    }

    fun onMinSdkChange(value: String) {
        updateMutableIntFlow(value, _minSdk)
    }

    fun onCompileSdkChange(value: String) {
        updateMutableIntFlow(value, _compileSdk)
    }

    fun onTargetSdkChange(value: String) {
        updateMutableIntFlow(value, _targetSdk)
    }

    fun onDownloadClick() {
        viewModelScope.launch {
            val generatedId = service.generate(
                GenerateProjectDto(
                    BuildSrcDto(
                        targetSdk = targetSdk.value,
                        minSdk = minSdk.value,
                        compileSdk = compileSdk.value,
                        applicationId = projectArtifact.value
                    )
                )
            ) ?: return@launch

            service.download(
                ProjectInfoDto(
                    uuid = generatedId,
                    projectName = projectFileName.value
                )
            )
        }
    }

    private fun updateMutableIntFlow(value: String, flow: MutableStateFlow<Int>) {
        val newValue: Int? = try {
            value.toInt()
        } catch (_: Exception) {
            null
        }

        if (newValue != null)
            flow.value = newValue
    }

    private companion object {
        const val DEFAULT_PROJECT_ARTIFACT = "com.example.android_app"
        const val ZIP_EXTENSION = ".zip"
        const val MIN_SDK_DEFAULT = 24
        const val COMPILE_SDK_DEFAULT = 33
        const val TARGET_SDK_DEFAULT = 33
    }
}
