package org.locker.start_android.presentation.compose.panes.start_pane.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.common.MarsiTextField
import org.locker.start_android.presentation.compose.theme.Black
import org.locker.start_android.presentation.compose.theme.Size28
import org.locker.start_android.presentation.compose.theme.Space8
import org.locker.start_android.presentation.compose.theme.Typography
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.project_artifact

@Composable
fun DownloadProjectArtifact(
    onConfigureClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = stringResource(Res.string.project_artifact),
            style = Typography.titleMedium,
            color = Black,
            modifier = Modifier.padding(bottom = Space8)
        )

        var value by remember { mutableStateOf("com.example.android_app") }
        MarsiTextField(
            value = value,
            onValueChanged = { new -> value = new },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Space8)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.weight(1f))

            ConfigureButton(
                onClick = onConfigureClick,
                height = Size28,
            )
        }
    }
}
