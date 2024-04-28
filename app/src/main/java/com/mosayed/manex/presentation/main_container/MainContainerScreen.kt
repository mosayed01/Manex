package com.mosayed.manex.presentation.main_container

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mosayed.manex.presentation.theme.Gray
import com.mosayed.manex.presentation.theme.LocalSnackbarHostState
import com.mosayed.manex.presentation.theme.White
import com.mosayed.manex.presentation.transactions.ui.TransactionsScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainContainerScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    CompositionLocalProvider(value = LocalSnackbarHostState provides snackbarHostState) {
        val navController = rememberNavController()
        var navigationSelectedItem by remember {
            mutableIntStateOf(0)
        }
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            bottomBar = {
                NavigationBar(
                    containerColor = White
                ) {
                    BottomBarItemUI.bottomBars().forEachIndexed { index, bottomBarItemUI ->
                        val selected = index == navigationSelectedItem
                        val color = if (selected) MaterialTheme.colorScheme.primary else Gray

                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                navigationSelectedItem = index
                                navController.navigate(bottomBarItemUI.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = bottomBarItemUI.iconRes),
                                    contentDescription = "bottom bar item ${bottomBarItemUI.title}",
                                    tint = color,
                                    modifier = Modifier.size(16.dp)
                                )
                            },
                            label = {
                                Text(
                                    text = bottomBarItemUI.title,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = color
                                    )
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(it)
            ) {
                composable(Screen.Transactions.route) {
                    TransactionsScreen()
                }
                composable(Screen.Politics.route) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "السياسات")
                    }
                }
                composable(Screen.MyCompanies.route) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "شركاتي")
                    }
                }
                composable(Screen.Home.route) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "الرئيسة")
                    }
                }
            }
        }
    }
}