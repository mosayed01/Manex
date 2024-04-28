package com.mosayed.manex.domain.transactions

import kotlinx.datetime.LocalDateTime

data class TransactionEntity(
    val id: String,
    val price: Double,
    val location: String,
    val date: LocalDateTime,
)
