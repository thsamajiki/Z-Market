package com.hero.z_market.utils

import java.text.NumberFormat
import java.util.Locale

object FormatUtil {
    fun formatWithComma(number: Int?): String {
        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        return numberFormat.format(number)
    }
}