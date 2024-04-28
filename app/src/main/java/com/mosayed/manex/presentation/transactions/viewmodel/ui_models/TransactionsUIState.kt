package com.mosayed.manex.presentation.transactions.viewmodel.ui_models

data class TransactionsUIState(
    val transactions: List<TransactionItemUI> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)
