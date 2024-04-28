package com.mosayed.manex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mosayed.manex.presentation.theme.ManexTheme
import com.mosayed.manex.presentation.transactions.ui.TransactionsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManexTheme {
                TransactionsScreen()
            }
        }
    }
}
