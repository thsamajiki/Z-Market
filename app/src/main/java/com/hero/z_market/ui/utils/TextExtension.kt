package com.hero.z_market.ui.utils

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object TextExtension {
    fun Modifier.visibility(isVisible: Boolean): Modifier =
        if (isVisible) this else this.then(Modifier.size(0.dp))
}