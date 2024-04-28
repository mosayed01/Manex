package com.mosayed.manex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.toArgb
import com.mosayed.manex.presentation.main_container.MainContainerScreen
import com.mosayed.manex.presentation.theme.ManexTheme
import com.mosayed.manex.presentation.theme.PrimaryLight
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = PrimaryLight.toArgb(),
                darkScrim = PrimaryLight.toArgb()
            )
        )
        setContent {
            ManexTheme {
                MainContainerScreen()
            }
        }
    }
}
