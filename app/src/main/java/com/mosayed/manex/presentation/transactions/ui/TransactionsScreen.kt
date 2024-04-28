package com.mosayed.manex.presentation.transactions.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mosayed.manex.presentation.theme.LocalSnackbarHostState
import com.mosayed.manex.presentation.theme.ManexTheme
import com.mosayed.manex.presentation.transactions.ui.components.NumberOfTransactions
import com.mosayed.manex.presentation.transactions.ui.components.TransactionItem
import com.mosayed.manex.presentation.transactions.viewmodel.TransactionsViewModel
import com.mosayed.manex.presentation.transactions.viewmodel.ui_models.TransactionItemUI
import com.mosayed.manex.presentation.transactions.viewmodel.ui_models.TransactionsUIState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TransactionsScreen(
    modifier: Modifier = Modifier,
    viewModel: TransactionsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = LocalSnackbarHostState.current

    LaunchedEffect(key1 = Unit) {
        viewModel.messageFlow.collectLatest {
            it?.let {
                snackbarHostState.showSnackbar(
                    it,
                )
            }
        }
    }
    TransactionsScreenContent(
        state = state,
        reloadTransactions = viewModel::getTransactions,
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TransactionsScreenContent(
    state: TransactionsUIState,
    reloadTransactions: () -> Unit,
    modifier: Modifier = Modifier,
) {
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
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        NumberOfTransactions(
            transactionsCount = state.transactions.size,
            query = text,
            onQueryChange = { text = it },
            visible = !isScrollDown,
        )
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(state.transactions, key = { it.id }) { transition ->
                TransactionItem(
                    transaction = transition,
                    modifier = Modifier.animateItemPlacement()
                )
            }
            if (state.isLoading || state.transactions.isEmpty() || state.error != null) {
                item {
                    Crossfade(
                        targetState = state.isLoading,
                        label = "animated items"
                    ) {
                        if (it) CircularProgressIndicator()
                        else {
                            Button(onClick = reloadTransactions) {
                                Text("تحميل مجددا", style = MaterialTheme.typography.labelSmall)
                            }
                        }
                    }
                }
            }
        }
    }
}

@PreviewScreenSizes
@Composable
private fun TransactionsScreenPreview() {
    ManexTheme {
        TransactionsScreenContent(
            TransactionsUIState(
                transactions = listOf(
                    TransactionItemUI(
                    ),
                    TransactionItemUI(
                    ),
                ),
                isLoading = false,
                error = null
            ),
            {}
        )
    }
}