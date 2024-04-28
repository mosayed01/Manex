package com.mosayed.manex.presentation.transactions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosayed.manex.presentation.transactions.viewmodel.ui_models.TransactionItemUI
import com.mosayed.manex.presentation.transactions.viewmodel.ui_models.TransactionsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(

) : ViewModel() {
    private val _state = MutableStateFlow(TransactionsUIState())
    val state = _state.asStateFlow()

    init {
        getTransactions()
    }

    private fun getTransactions() {
        // todo: get transactions from use case
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            delay(1000)
            _state.update {
                it.copy(
                    isLoading = false,
                    transactions = listOf(
                        TransactionItemUI(
                            price = 444,
                            location = "مصر",
                            date = "5/5/2022",
                            time = "04:00 مساءا"
                        ),
                        TransactionItemUI(
                            price = 444,
                            location = "مصر",
                            date = "5/5/2022",
                            time = "04:00 مساءا"
                        ),
                        TransactionItemUI(
                            price = 444,
                            location = "مصر",
                            date = "5/5/2022",
                            time = "04:00 مساءا"
                        ),
                        TransactionItemUI(
                            price = 444,
                            location = "مصر",
                            date = "5/5/2022",
                            time = "04:00 مساءا"
                        ),
                        TransactionItemUI(
                            price = 444,
                            location = "مصر",
                            date = "5/5/2022",
                            time = "04:00 مساءا"
                        ),
                    )
                )
            }
        }
    }
}