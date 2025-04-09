package org.locker.start_android.presentation.compose.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape


val DefaultShape: Shape = RoundedCornerShape(SmallCornerPercent)
val RoundedShape: Shape = RoundedCornerShape(RoundCornerPercent)

val DefaultBorderStroke: BorderStroke = BorderStroke(BorderWidth, LightGreyColor)
val BlackBorderStroke: BorderStroke = BorderStroke(BorderWidth, Black)

val TopBarWidthModifier: Modifier = Modifier.width(Size1280)
val MainPainWidthModifier: Modifier = Modifier.width(Size1216)

val TextField48PaddingValues = PaddingValues(Space8)
val SpinnerPaddingValues = PaddingValues(Space8)

val AccentButtonColors: ButtonColors
    @Composable
    get() = ButtonDefaults.buttonColors(
        containerColor = AccentColor,
        contentColor = Color.White
    )

val AdditionalButtonColors: ButtonColors
    @Composable
    get() = ButtonDefaults.buttonColors(
        containerColor = Color.White,
        contentColor = Black
    )

val WhiteTextFieldColors: TextFieldColors
    @Composable
    get() = TextFieldDefaults.colors(
        focusedTextColor = Black,
        unfocusedTextColor = LightGreyColor,
        disabledTextColor = LightGreyColor,
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        disabledContainerColor = Color.White,
        errorContainerColor = Color.White,
        cursorColor = Black,
        focusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
    )

val MarsiCheckBoxColors: CheckboxColors
    @Composable
    get() = CheckboxDefaults.colors(
        checkedColor = AccentColor,
        uncheckedColor = AccentColor,
        checkmarkColor = Black
    )

val TransparentClickableButtonColors
    @Composable
    get() = ButtonDefaults.buttonColors(containerColor = Color.Transparent)

