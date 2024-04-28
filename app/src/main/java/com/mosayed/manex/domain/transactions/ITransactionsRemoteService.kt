package com.mosayed.manex.domain.transactions

interface ITransactionsRemoteService {
    suspend fun getTransactions(): List<TransactionEntity>
}