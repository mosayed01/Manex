package com.mosayed.manex.data.transactions.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TransactionsResponse(
    @SerialName("numOfTotalTrxs")
    val numOfTotalTrxs: Int? = null,
    @SerialName("transactions")
    val transactions: List<TransactionDto?>? = null
)