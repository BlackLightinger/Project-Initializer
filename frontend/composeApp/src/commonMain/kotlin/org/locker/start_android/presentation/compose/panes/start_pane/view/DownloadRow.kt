package org.locker.start_android.presentation.compose.panes.start_pane.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.theme.Black
import org.locker.start_android.presentation.compose.theme.DarkGreyColor
import org.locker.start_android.presentation.compose.theme.Size64
import org.locker.start_android.presentation.compose.theme.Space16
import org.locker.start_android.presentation.compose.theme.Typography
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.new_android_project
import startandroid.composeapp.generated.resources.new_project_description

@Composable
fun DownloadRow(
    onDownloadClick: () -> Unit,
    onConfigureClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        DownloadRowText(modifier = Modifier.fillMaxHeight().weight(1f))

        DownloadCard(
            onDownloadClick = onDownloadClick,
            onConfigureClick = onConfigureClick,
            fileName = "start_android.zip",
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        )
    }
}

@Composable
private fun DownloadRowText(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = stringResource(Res.string.new_android_project),
                color = Black,
                style = Typography.displayLarge,
                modifier = Modifier.padding(bottom = Space16)
            )

            Text(
                text = stringResource(Res.string.new_project_description),
                color = DarkGreyColor,
                style = Typography.titleSmall
            )
        }

        Spacer(modifier = Modifier.width(Size64))
    }
}
