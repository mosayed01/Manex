package com.mosayed.manex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.mosayed.manex.ui.theme.Black87
import com.mosayed.manex.ui.theme.ManexTheme
import com.mosayed.manex.ui.theme.PrimaryLight
import com.mosayed.manex.ui.theme.Gray
import com.mosayed.manex.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ManexTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(0.3f)
                            .fillMaxWidth()
                            .background(PrimaryLight)
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Greeting(
                            "عدد المعاملات الكلي",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Gray
                            )
                        )
                        Greeting(
                            "73 معاملة",
                            style = MaterialTheme.typography.displayLarge.copy(
                                color = White
                            )
                        )
                        Greeting(
                            "فرز المعاملات",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Gray
                            )
                        )
                        Greeting(
                            " 432 ج.م",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Black87,
                                fontWeight = FontWeight.ExtraBold
                            )
                        )
                        Greeting(
                            "الجيزة",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = Gray
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyLarge
) {
    Text(
        text = name,
        modifier = modifier,
        style = style,
    )
}

@PreviewScreenSizes
@Composable
fun GreetingPreview() {
    ManexTheme {
        Greeting("Android")
    }
}