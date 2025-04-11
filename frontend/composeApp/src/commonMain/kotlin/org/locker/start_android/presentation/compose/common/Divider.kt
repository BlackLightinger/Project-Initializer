package org.locker.start_android.presentation.compose.common

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.locker.start_android.presentation.compose.theme.DarkGreyColor
import org.locker.start_android.presentation.compose.theme.StrokeSize1

@Composable
fun StartAndroidHorizontalDivider(
    color: Color = DarkGreyColor,
    modifier: Modifier = Modifier
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = StrokeSize1,
        color = color
    )
}

@Composable
fun StartAndroidVerticalDivider(
    color: Color = DarkGreyColor,
    modifier: Modifier = Modifier
) {
    VerticalDivider(
        modifier = modifier,
        thickness = StrokeSize1,
        color = color
    )
}
