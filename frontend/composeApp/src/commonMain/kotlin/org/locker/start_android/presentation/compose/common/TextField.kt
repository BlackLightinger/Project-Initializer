package org.locker.start_android.presentation.compose.common


import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import org.locker.start_android.presentation.compose.theme.Black
import org.locker.start_android.presentation.compose.theme.BlackBorderStroke
import org.locker.start_android.presentation.compose.theme.DarkGreyColor
import org.locker.start_android.presentation.compose.theme.DefaultBorderStroke
import org.locker.start_android.presentation.compose.theme.DefaultShape
import org.locker.start_android.presentation.compose.theme.LightGreyColor
import org.locker.start_android.presentation.compose.theme.Size48
import org.locker.start_android.presentation.compose.theme.Space4
import org.locker.start_android.presentation.compose.theme.TextField48PaddingValues
import org.locker.start_android.presentation.compose.theme.Typography
import org.locker.start_android.presentation.compose.theme.WhiteTextFieldColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartAndroidTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    labelTextStyle: TextStyle = Typography.titleSmall,
    labelBottomPadding: Dp = Space4,
    isEnabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeHolder: String? = label,
    contentPadding: PaddingValues = TextField48PaddingValues,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIconInside: @Composable (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
    ) {
        if (label != null) {
            Text(
                text = label,
                style = labelTextStyle,
                color = DarkGreyColor,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = Space4, bottom = labelBottomPadding)
            )
        }

        val interactionSource = remember { MutableInteractionSource() }
        val isFocused = interactionSource.collectIsFocusedAsState()
        val borderModifier = Modifier.border(
            if (isFocused.value) BlackBorderStroke else DefaultBorderStroke,
            shape = DefaultShape
        )

        BasicTextField(
            value = value,
            onValueChange = onValueChanged,
            modifier = textModifier.fillMaxWidth().heightIn(min = Size48).then(borderModifier),
            singleLine = true,
            enabled = isEnabled,
            readOnly = readOnly,
            interactionSource = interactionSource,
            textStyle = Typography.bodyLarge.merge(TextStyle(Black)),
            cursorBrush = SolidColor(Black),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation
        ) { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value,
                visualTransformation = visualTransformation,
                innerTextField = innerTextField,
                singleLine = true,
                enabled = true,
                interactionSource = interactionSource,
                shape = DefaultShape,
                colors = WhiteTextFieldColors,
                placeholder = {
                    if (placeHolder != null) {
                        Text(
                            text = placeHolder,
                            color = LightGreyColor,
                            style = Typography.bodyLarge
                        )
                    }
                },
                contentPadding = contentPadding,
                trailingIcon = trailingIconInside
            )
        }
    }
}



