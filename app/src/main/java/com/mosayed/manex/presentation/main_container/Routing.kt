package com.mosayed.manex.presentation.main_container

import androidx.annotation.DrawableRes
import com.mosayed.manex.R


sealed class Screen(val route: String) {
    data object Home : Screen("/home")
    data object MyCompanies : Screen("/my_companies")
    data object Politics : Screen("/politics")
    data object Transactions : Screen("/transactions")
}

data class BottomBarItemUI(
    val title: String,
    @DrawableRes val iconRes: Int,
    val route: String,
) {
    companion object {
        fun bottomBars(): List<BottomBarItemUI> = listOf(
            BottomBarItemUI(
                "الرئيسية",
                R.drawable.home,
                Screen.Home.route
            ),
            BottomBarItemUI(
                "شركاتي",
                R.drawable.master_corporate,
                Screen.MyCompanies.route
            ),
            BottomBarItemUI(
                "معاملاتي",
                R.drawable.transactions,
                Screen.Transactions.route
            ),
            BottomBarItemUI(
                "السياسات",
                R.drawable.policy,
                Screen.Politics.route
            ),
        )
    }
}