package org.locker.start_android.presentation.compose.panes.dependencies.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.locker.start_android.presentation.compose.theme.AccentColor
import org.locker.start_android.presentation.compose.theme.Black
import org.locker.start_android.presentation.compose.theme.Size24
import org.locker.start_android.presentation.compose.theme.Size64
import org.locker.start_android.presentation.compose.theme.Space16
import org.locker.start_android.presentation.compose.theme.Space4
import org.locker.start_android.presentation.compose.theme.Typography
import org.locker.start_android.presentation.model.DependencyViewData
import startandroid.composeapp.generated.resources.Res
import startandroid.composeapp.generated.resources.ic_android_name
import startandroid.composeapp.generated.resources.ic_prime_android


@Composable
fun DependencyItem(
    dependency: DependencyViewData,
    isAdded: Boolean,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.clickable {
            onItemClick()
        }
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_prime_android),
            contentDescription = stringResource(Res.string.ic_android_name),
            tint = AccentColor,
            modifier = Modifier.padding(end = Space16)
        )

        Text(
            text = dependency.name,
            style = Typography.titleLarge,
            color = Black
        )

        if (isAdded) {
            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(AccentColor)
                    .size(Size24)
            )

            Spacer(modifier = Modifier.width(Space16))
        }
    }
}

@Composable
fun DependenciesList(
    dependenciesToShow: List<DependencyViewData>,
    addedDependencies: List<DependencyViewData>,
    onItemClick: (DependencyViewData) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(dependenciesToShow) { dependency ->
            DependencyItem(
                dependency = dependency,
                onItemClick = { onItemClick(dependency) },
                isAdded = dependency in addedDependencies,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Size64)
                    .padding(bottom = Space4)
            )
        }
    }
}
