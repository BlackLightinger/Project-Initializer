package org.locker.start_android.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.koin.compose.KoinApplication
import org.locker.start_android.di.httpClientModule
import org.locker.start_android.di.repositoryModule
import org.locker.start_android.di.serviceModule
import org.locker.start_android.di.viewModelModule
import org.locker.start_android.presentation.compose.panes.start_pane.pane.StartPane
import org.locker.start_android.presentation.compose.theme.StartAndroidTheme

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(
                viewModelModule,
                httpClientModule,
                serviceModule,
                repositoryModule
            )
        }
    ) {
        StartAndroidTheme {
            StartPane(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
