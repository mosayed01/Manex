package com.mosayed.manex.presentation.transactions.viewmodel.ui_models

import com.mosayed.manex.domain.transactions.TransactionEntity
import kotlinx.datetime.LocalDateTime
import kotlin.math.roundToInt

internal fun List<TransactionEntity>.toUI() = map(TransactionEntity::toUI)

internal fun TransactionEntity.toUI() = TransactionItemUI(
    id = id,
    price = price.roundToInt(),
    location = location,
    date = date.toFormattedDate(),
    time = date.toFormattedTime()
)

fun LocalDateTime.toFormattedDate(): String {
    val day = dayOfMonth.toString().padStart(2, '0')
    val month = monthNumber.toString().padStart(2, '0')
    val year = year.toString()
    return "$day / $month / $year"
}

fun LocalDateTime.toFormattedTime(): String {
    val hour = this.hour
    val minute = this.minute.toString().padStart(2, '0')

    return if (hour <= 12) {
        "$hour:$minute صباحاً"
    } else {
        "${hour - 12}:$minute مساءً"
    }
}