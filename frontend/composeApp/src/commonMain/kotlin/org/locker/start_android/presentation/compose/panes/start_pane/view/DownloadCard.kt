package org.locker.start_android.presentation.compose.panes.start_pane.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.locker.start_android.presentation.compose.common.StartAndroidVerticalDivider
import org.locker.start_android.presentation.compose.theme.DefaultBorderStroke
import org.locker.start_android.presentation.compose.theme.DefaultShape
import org.locker.start_android.presentation.compose.theme.LightGreyColor
import org.locker.start_android.presentation.compose.theme.Size32
import org.locker.start_android.presentation.compose.theme.Space16
import org.locker.start_android.presentation.compose.theme.Space32


@Composable
fun DownloadCard(
    onDownloadClick: () -> Unit,
    artifactValue: String,
    onArtifactValueChange: (String) -> Unit,
    fileName: String,
    minSdk: Int,
    targetSdk: Int,
    compileSdk: Int,
    onMinSdkChange: (String) -> Unit,
    onTargetSdkChange: (String) -> Unit,
    onCompileSdkChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.border(
            border = DefaultBorderStroke,
            shape = DefaultShape
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(horizontal = Space32, vertical = Space16)
                .fillMaxWidth()
        ) {
            DownloadProjectArtifact(
                artifactValue = artifactValue,
                onArtifactChange = onArtifactValueChange,
                minSdk = minSdk,
                targetSdk = targetSdk,
                compileSdk = compileSdk,
                onMinSdkChange = onMinSdkChange,
                onTargetSdkChange = onTargetSdkChange,
                onCompileSdkChange = onCompileSdkChange,
                modifier = Modifier.weight(3f)
            )

            Spacer(Modifier.width(Size32))

            StartAndroidVerticalDivider(
                color = LightGreyColor,
            )

            Spacer(Modifier.width(Size32))

            DownloadButtonWithProjectName(
                onDownloadClick = onDownloadClick,
                fileName = fileName,
                modifier = Modifier.weight(2f)
            )
        }
    }
}
