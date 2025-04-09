package org.locker.start_android.presentation.compose.panes.start_pane.pane


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.locker.start_android.presentation.compose.common.StartAndroidHorizontalDivider
import org.locker.start_android.presentation.compose.common.noRippleClickable
import org.locker.start_android.presentation.compose.navigation.MainNavHost
import org.locker.start_android.presentation.compose.navigation.ProjectNavigationBar
import org.locker.start_android.presentation.compose.panes.start_pane.view.DownloadRow
import org.locker.start_android.presentation.compose.panes.start_pane.view.TopBarRow
import org.locker.start_android.presentation.compose.theme.LightGreyColor
import org.locker.start_android.presentation.compose.theme.MainPainWidthModifier
import org.locker.start_android.presentation.compose.theme.Size160
import org.locker.start_android.presentation.compose.theme.Size32
import org.locker.start_android.presentation.compose.theme.Size72
import org.locker.start_android.presentation.compose.theme.Space16
import org.locker.start_android.presentation.compose.theme.Space32
import org.locker.start_android.presentation.compose.theme.TopBarWidthModifier


@Composable
fun StartPane(
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.noRippleClickable {
            focusManager.clearFocus(true)
        }
    ) {
        TopBarRow(
            modifier = TopBarWidthModifier
                .height(Size72)
        )

        StartAndroidHorizontalDivider(
            color = LightGreyColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Space32)
        )

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = MainPainWidthModifier.weight(1f)
        ) {

            DownloadRow(
                onDownloadClick = {},
                onConfigureClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Size160)
                    .padding(bottom = Space16)
            )

            ProjectNavigationBar(
                navigatePane = { paneName ->
                    navController.navigate(paneName) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                currentRoute = currentRoute,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = Space16)
                    .height(Size32)
            )

            MainNavHost(
                navHostController = navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}

