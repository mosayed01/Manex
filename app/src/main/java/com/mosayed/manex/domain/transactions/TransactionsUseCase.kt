package com.mosayed.manex.domain.transactions

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

interface ITransactionsUseCase {
    suspend fun getTransactions(): List<TransactionEntity>
}

@ViewModelScoped
class TransactionsUseCase @Inject constructor(
    private val transactionsRemoteService: ITransactionsRemoteService
) : ITransactionsUseCase {
    override suspend fun getTransactions(): List<TransactionEntity> {
        return transactionsRemoteService.getTransactions()
            .sortedByDescending { it.date }
    }
}