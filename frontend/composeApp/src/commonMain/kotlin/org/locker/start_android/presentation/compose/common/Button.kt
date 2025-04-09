package org.locker.start_android.presentation.compose.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import org.locker.start_android.presentation.compose.theme.AccentButtonColors
import org.locker.start_android.presentation.compose.theme.AccentColor
import org.locker.start_android.presentation.compose.theme.RoundedShape
import org.locker.start_android.presentation.compose.theme.Size16
import org.locker.start_android.presentation.compose.theme.Size32
import org.locker.start_android.presentation.compose.theme.Typography

@Composable
fun StartAndroidButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    height: Dp = Size32,
    textStyle: TextStyle = Typography.titleMedium,
    colors: ButtonColors = AccentButtonColors,
    borderStroke: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    icon: (@Composable () -> Unit)? = null
) {
    Button(
        onClick = onClick,
        shape = RoundedShape,
        colors = colors,
        border = borderStroke,
        contentPadding = contentPadding,
        modifier = modifier.height(height)
    ) {
        Text(
            text = text,
            style = textStyle
        )

        if (icon != null) {
            Spacer(modifier = Modifier.width(Size16))

            icon()
        }
    }
}


