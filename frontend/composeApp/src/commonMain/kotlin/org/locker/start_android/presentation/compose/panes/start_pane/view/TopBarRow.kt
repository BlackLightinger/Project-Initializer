package org.locker.start_android.presentation.compose.panes.start_pane.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.theme.AccentColor
import org.locker.start_android.presentation.compose.theme.Black
import org.locker.start_android.presentation.compose.theme.DarkGreyColor
import org.locker.start_android.presentation.compose.theme.Size24
import org.locker.start_android.presentation.compose.theme.Typography
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.ic_android_name
import startandroid.composeapp.generated.resources.ic_prime_android
import startandroid.composeapp.generated.resources.ic_profile
import startandroid.composeapp.generated.resources.ic_profile_name
import startandroid.composeapp.generated.resources.start_android

@Composable
fun TopBarRow(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_prime_android),
            contentDescription = stringResource(Res.string.ic_android_name),
            tint = AccentColor
        )

        Text(
            text = stringResource(Res.string.start_android),
            color = Black,
            style = Typography.displayLarge
        )

        Spacer(Modifier.weight(1f))

        Icon(
            painter = painterResource(Res.drawable.ic_profile),
            contentDescription = stringResource(Res.string.ic_profile_name),
            tint = DarkGreyColor,
            modifier = Modifier.size(Size24)
        )
    }
}
