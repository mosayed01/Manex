package com.mosayed.manex.data.transactions.dto

import com.mosayed.manex.data.utils.getCurrentDateTime
import com.mosayed.manex.domain.transactions.TransactionEntity
import kotlinx.datetime.LocalDateTime
import java.util.UUID

internal fun TransactionDto.toEntity() = TransactionEntity(
    id = UUID.randomUUID().toString(),
    price = price ?: 0.0,
    location = location ?: "بولاق",
    date = timestamp?.let { LocalDateTime.parse(it) } ?: getCurrentDateTime()
)