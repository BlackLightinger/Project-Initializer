package org.locker.start_android.presentation.compose.panes.start_pane.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.theme.Space8
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.compile_sdk
import startandroid.composeapp.generated.resources.min_sdk
import startandroid.composeapp.generated.resources.project_artifact
import startandroid.composeapp.generated.resources.target_sdk

@Composable
fun DownloadProjectArtifact(
    artifactValue: String,
    onArtifactChange: (String) -> Unit,
    minSdk: Int,
    targetSdk: Int,
    compileSdk: Int,
    onMinSdkChange: (String) -> Unit,
    onTargetSdkChange: (String) -> Unit,
    onCompileSdkChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {

        ConfigureTextField(
            value = artifactValue,
            onValueChange = onArtifactChange,
            label = stringResource(Res.string.project_artifact),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Space8)
        )

        ConfigureTextField(
            value = minSdk.toString(),
            onValueChange = onMinSdkChange,
            label = stringResource(Res.string.min_sdk),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Space8)
        )

        ConfigureTextField(
            value = compileSdk.toString(),
            onValueChange = onCompileSdkChange,
            label = stringResource(Res.string.compile_sdk),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Space8)
        )

        ConfigureTextField(
            value = targetSdk.toString(),
            onValueChange = onTargetSdkChange,
            label = stringResource(Res.string.target_sdk),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Space8)
        )
    }
}

@Composable
private fun ConfigureTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier
    )
}
