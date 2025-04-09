package org.locker.start_android.presentation.compose.panes.start_pane.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
    onConfigureClick: () -> Unit,
    fileName: String,
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
                .fillMaxSize()
        ) {
            DownloadProjectArtifact(
                onConfigureClick = onConfigureClick,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f)
            )

            Spacer(Modifier.width(Size32))

            StartAndroidVerticalDivider(
                color = LightGreyColor,
                modifier = Modifier.fillMaxHeight()
            )

            Spacer(Modifier.width(Size32))

            DownloadButtonWithProjectName(
                onDownloadClick = onDownloadClick,
                fileName = fileName,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
            )
        }
    }
}
