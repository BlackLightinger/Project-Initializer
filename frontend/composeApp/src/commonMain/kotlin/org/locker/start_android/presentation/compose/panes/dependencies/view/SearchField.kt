package org.locker.start_android.presentation.compose.panes.dependencies.view

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.common.StartAndroidTextField
import org.locker.start_android.presentation.compose.theme.DarkGreyColor
import org.locker.start_android.presentation.compose.theme.Size32
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.ic_search
import startandroid.composeapp.generated.resources.ic_search_name
import startandroid.composeapp.generated.resources.search_dependencies

@Composable
fun SearchDependencyField(
    searchValue: String,
    onSearchValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    StartAndroidTextField(
        value = searchValue,
        onValueChanged = onSearchValueChanged,
        placeHolder = stringResource(Res.string.search_dependencies),
        trailingIconInside = {
            Icon(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = stringResource(Res.string.ic_search_name),
                tint = DarkGreyColor,
                modifier = Modifier.size(Size32)
            )
        },
        modifier = modifier
    )

}
