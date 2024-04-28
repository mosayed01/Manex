package com.mosayed.manex.data.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun getCurrentDateTime() = Clock.System.now()
    .toLocalDateTime(TimeZone.currentSystemDefault())