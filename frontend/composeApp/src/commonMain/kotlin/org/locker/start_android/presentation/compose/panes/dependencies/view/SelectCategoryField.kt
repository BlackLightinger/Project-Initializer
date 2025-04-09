package org.locker.start_android.presentation.compose.panes.dependencies.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.util.fastForEach
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.theme.Black
import org.locker.start_android.presentation.compose.theme.BlackBorderStroke
import org.locker.start_android.presentation.compose.theme.DarkGreyColor
import org.locker.start_android.presentation.compose.theme.DefaultBorderStroke
import org.locker.start_android.presentation.compose.theme.DefaultShape
import org.locker.start_android.presentation.compose.theme.LightGreyColor
import org.locker.start_android.presentation.compose.theme.Size32
import org.locker.start_android.presentation.compose.theme.Size64
import org.locker.start_android.presentation.compose.theme.Space8
import org.locker.start_android.presentation.compose.theme.SpinnerPaddingValues
import org.locker.start_android.presentation.compose.theme.Typography
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.ic_cancel
import startandroid.composeapp.generated.resources.ic_cancel_name
import startandroid.composeapp.generated.resources.ic_dropdown_arrow_name
import startandroid.composeapp.generated.resources.select_category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectCategoryField(
    items: List<String>,
    selectedItem: String?,
    unSelectItem: () -> Unit,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
            .height(Size64)
            .clip(DefaultShape)
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(SpinnerPaddingValues)
                .border(
                    if (expanded) BlackBorderStroke else DefaultBorderStroke,
                    shape = DefaultShape
                )
                .menuAnchor(MenuAnchorType.PrimaryNotEditable)
        ) {
            Text(
                text = selectedItem ?: stringResource(Res.string.select_category),
                style = Typography.bodyLarge,
                color = if (selectedItem != null) Black else LightGreyColor,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = Space8)
            )

            if (selectedItem != null) {
                Icon(
                    painter = painterResource(Res.drawable.ic_cancel),
                    contentDescription = stringResource(Res.string.ic_cancel_name),
                    tint = DarkGreyColor,
                    modifier = Modifier.size(Size32).clickable {
                        unSelectItem()
                        expanded = false
                    }
                )
            }

            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(Res.string.ic_dropdown_arrow_name),
                tint = DarkGreyColor,
                modifier = Modifier.size(Size32)
            )
        }


        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = Color.White
        ) {
            items.fastForEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option,
                            style = Typography.bodyLarge,
                            maxLines = 1,
                            color = if (option == selectedItem) Color.White else DarkGreyColor
                        )
                    },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    modifier = Modifier.background(
                        color = if (option == selectedItem) Black else Color.White
                    )
                )
            }
        }
    }
}
