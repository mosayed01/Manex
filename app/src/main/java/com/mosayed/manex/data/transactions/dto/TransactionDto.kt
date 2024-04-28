package com.mosayed.manex.data.transactions.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TransactionDto(
    @SerialName("location")
    val location: String? = null,
    @SerialName("price")
    val price: Double? = null,
    @SerialName("timestamp")
    val timestamp: String? = null
)