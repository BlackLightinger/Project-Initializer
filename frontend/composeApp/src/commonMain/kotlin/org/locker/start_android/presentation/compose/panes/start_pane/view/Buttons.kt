package org.locker.start_android.presentation.compose.panes.start_pane.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.common.StartAndroidButton
import org.locker.start_android.presentation.compose.theme.AdditionalButtonColors
import org.locker.start_android.presentation.compose.theme.Black
import org.locker.start_android.presentation.compose.theme.DefaultBorderStroke
import org.locker.start_android.presentation.compose.theme.Size48
import org.locker.start_android.presentation.compose.theme.Size8
import org.locker.start_android.presentation.compose.theme.Space4
import org.locker.start_android.presentation.compose.theme.Space8
import org.locker.start_android.presentation.compose.theme.Typography
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.configure
import startandroid.composeapp.generated.resources.download
import startandroid.composeapp.generated.resources.ic_configure
import startandroid.composeapp.generated.resources.ic_configure_name
import startandroid.composeapp.generated.resources.ic_download
import startandroid.composeapp.generated.resources.ic_download_name

@Composable
fun ConfigureButton(
    onClick: () -> Unit,
    height: Dp,
    modifier: Modifier = Modifier
) {
    StartAndroidButton(
        onClick = onClick,
        text = stringResource(Res.string.configure),
        height = height,
        textStyle = Typography.bodyMedium,
        borderStroke = DefaultBorderStroke,
        colors = AdditionalButtonColors,
        contentPadding = PaddingValues(horizontal = Space8, vertical = Space4),
        modifier = modifier,
        icon = {
            Icon(
                painter = painterResource(Res.drawable.ic_configure),
                contentDescription = stringResource(Res.string.ic_configure_name),
                modifier = Modifier.fillMaxHeight()
            )
        }
    )
}

@Composable
fun DownloadButton(
    onClick: () -> Unit,
    height: Dp,
    modifier: Modifier = Modifier
) {
    StartAndroidButton(
        onClick = onClick,
        text = stringResource(Res.string.download),
        height = height,
        textStyle = Typography.titleMedium,
        modifier = modifier,
        icon = {
            Icon(
                painter = painterResource(Res.drawable.ic_download),
                contentDescription = stringResource(Res.string.ic_download_name),
                modifier = Modifier.size(height / 2)
            )
        }
    )
}

@Composable
fun DownloadButtonWithProjectName(
    onDownloadClick: () -> Unit,
    fileName: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        DownloadButton(
            onClick = onDownloadClick,
            height = Size48,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Size8))

        Text(
            text = fileName,
            style = Typography.bodyMedium,
            color = Black
        )
    }
}
