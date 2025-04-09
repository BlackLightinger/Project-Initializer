package org.locker.start_android.presentation.compose.panes.dependencies.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringArrayResource
import org.locker.start_android.presentation.compose.theme.Space8
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.categories

@Composable
fun SearchRow(
    searchValue: String,
    searchCategory: String?,
    onSearchValueChanged: (String) -> Unit,
    onSearchCategoryChanged: (String?) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        SearchDependencyField(
            searchValue = searchValue,
            onSearchValueChanged = onSearchValueChanged,
            modifier = Modifier.weight(2f)
        )

        Spacer(modifier = Modifier.width(Space8))

        SelectCategoryField(
            items = stringArrayResource(Res.array.categories),
            selectedItem = searchCategory,
            unSelectItem = { onSearchCategoryChanged(null) },
            onOptionSelected = onSearchCategoryChanged,
            modifier = Modifier.weight(1f)
        )
    }
}
