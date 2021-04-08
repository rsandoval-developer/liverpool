package com.liverpool.app.presentation.utils

import java.text.NumberFormat
import java.util.*

fun Double.formatPrice(): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 2
    format.currency = Currency.getInstance("MXN")
    return format.format(this)
}
