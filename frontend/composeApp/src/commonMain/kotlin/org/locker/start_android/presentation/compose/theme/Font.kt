package org.locker.start_android.presentation.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.inter_regular
import startandroid.composeapp.generated.resources.inter_semi_bold

val InterRegularFont: Font
    @Composable
    get() = Font(
        resource = Res.font.inter_regular,
        weight = FontWeight.Normal
    )

val InterSemiBoldFont: Font
    @Composable
    get() = Font(
        resource = Res.font.inter_semi_bold,
        weight = FontWeight.SemiBold
    )

val InterFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        InterRegularFont,
        InterSemiBoldFont
    )
