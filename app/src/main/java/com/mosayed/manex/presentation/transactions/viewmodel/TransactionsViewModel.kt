package com.mosayed.manex.presentation.transactions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosayed.manex.domain.GeneralException
import com.mosayed.manex.domain.transactions.ITransactionsUseCase
import com.mosayed.manex.presentation.transactions.viewmodel.ui_models.TransactionsUIState
import com.mosayed.manex.presentation.transactions.viewmodel.ui_models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val transactionsUseCase: ITransactionsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(TransactionsUIState())
    val state = _state.asStateFlow()

    private val _messageFlow = MutableStateFlow<String?>(null)
    val messageFlow = _messageFlow.asSharedFlow()

    init {
        getTransactions()
    }

    fun getTransactions() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true) }
                val transactions = transactionsUseCase.getTransactions()
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = null,
                        transactions = transactions.toUI()
                    )
                }
            } catch (exception: GeneralException){
                _messageFlow.emit(exception.errorMessage)
                _state.update { it.copy(error = exception.errorMessage, isLoading = false) }
            }
        }
    }
}