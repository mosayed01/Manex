package com.mosayed.manex.presentation.transactions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.mosayed.manex.presentation.theme.ManexTheme
import com.mosayed.manex.presentation.transactions.ui.components.NumberOfTransactions
import com.mosayed.manex.presentation.transactions.ui.components.TransactionItem

@Composable
fun TransactionsScreen() {
    var text by remember { mutableStateOf("") }
    val scrollState = rememberLazyListState()
    val firstItemVisibleIndex by remember { derivedStateOf { scrollState.firstVisibleItemIndex } }
    var isScrollDown by remember { mutableStateOf(false) }
    var lastFirstVisibleItemIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(firstItemVisibleIndex) {
        isScrollDown = scrollState.firstVisibleItemIndex > lastFirstVisibleItemIndex
        lastFirstVisibleItemIndex = scrollState.firstVisibleItemIndex
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .safeDrawingPadding()
            .background(MaterialTheme.colorScheme.background)
    ) {
        NumberOfTransactions(
            transactionsCount = 100,
            query = text,
            onQueryChange = { text = it },
            visible = !isScrollDown,
        )
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(100, key = { it }) {
                TransactionItem()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
private fun TransactionsScreenPreview() {
    ManexTheme {
        TransactionsScreen()
    }
}