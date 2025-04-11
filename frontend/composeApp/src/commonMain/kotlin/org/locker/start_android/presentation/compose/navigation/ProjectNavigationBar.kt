package org.locker.start_android.presentation.compose.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.util.fastForEach
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.common.StartAndroidHorizontalDivider
import org.locker.start_android.presentation.compose.common.StartAndroidVerticalDivider
import org.locker.start_android.presentation.compose.theme.AccentColor
import org.locker.start_android.presentation.compose.theme.DarkGreyColor
import org.locker.start_android.presentation.compose.theme.Size24
import org.locker.start_android.presentation.compose.theme.Space4
import org.locker.start_android.presentation.compose.theme.Space8
import org.locker.start_android.presentation.compose.theme.Typography


@Composable
fun ProjectNavigationBar(
    navigatePane: (String) -> Unit,
    modifier: Modifier = Modifier,
    currentRoute: String? = null,
) {
    val navPanes = Pane.NAV_PANES
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Space8),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            navPanes.fastForEach { pane ->
                val isSelected = currentRoute == pane.name

                NavigationButton(
                    onClick = {
                        navigatePane(pane.name)
                    },
                    text = stringResource(pane.textStringResource),
                    painter = painterResource(pane.iconDrawable),
                    contentDescription = stringResource(pane.contentDescriptionStringResource),
                    isActive = isSelected
                )

                StartAndroidVerticalDivider(modifier = Modifier.fillMaxHeight())
            }
        }

        StartAndroidHorizontalDivider(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun NavigationButton(
    onClick: () -> Unit,
    text: String,
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier,
    isActive: Boolean = false
) {
    val color = if (isActive) AccentColor else DarkGreyColor
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.clickable{
            onClick()
        }
    ) {
        Icon(
            painter = painter,
            tint = color,
            contentDescription = contentDescription,
            modifier = Modifier.size(Size24).padding(end = Space4)
        )

        Text(
            text = text,
            color = color,
            style = Typography.titleMedium
        )
    }
}
