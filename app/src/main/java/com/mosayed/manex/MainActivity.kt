package com.mosayed.manex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.mosayed.manex.presentation.theme.LocalSnackbarHostState
import com.mosayed.manex.presentation.theme.ManexTheme
import com.mosayed.manex.presentation.transactions.ui.TransactionsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManexTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                CompositionLocalProvider(value = LocalSnackbarHostState provides snackbarHostState) {
                    Scaffold(
                        snackbarHost = {
                            SnackbarHost(hostState = snackbarHostState)
                        }
                    ) {
                        TransactionsScreen()
                    }
                }
            }
        }
    }
}
