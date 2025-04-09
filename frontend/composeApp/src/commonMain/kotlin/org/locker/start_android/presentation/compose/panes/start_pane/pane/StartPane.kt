package org.locker.start_android.presentation.compose.panes.start_pane.pane


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import org.locker.start_android.presentation.compose.common.StartAndroidHorizontalDivider
import org.locker.start_android.presentation.compose.common.noRippleClickable
import org.locker.start_android.presentation.compose.panes.start_pane.view.TopBarRow
import org.locker.start_android.presentation.compose.theme.LightGreyColor
import org.locker.start_android.presentation.compose.theme.Size72
import org.locker.start_android.presentation.compose.theme.Space32
import org.locker.start_android.presentation.compose.theme.TopBarWidthModifier


@Composable
fun StartPane(
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.noRippleClickable {
            focusManager.clearFocus(true)
        }
    ) {
        TopBarRow(
            modifier = TopBarWidthModifier
                .height(Size72)
        )

        StartAndroidHorizontalDivider(
            color = LightGreyColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Space32)
        )

    }
}

