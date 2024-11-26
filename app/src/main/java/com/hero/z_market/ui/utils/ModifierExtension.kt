package com.hero.z_market.ui.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout

object ModifierExtension {
    fun Modifier.visible(isVisible: Boolean): Modifier = this.then(
        if (isVisible) Modifier
        else Modifier.layout { _, constraints ->
            layout(0, 0) {} // 요소를 레이아웃 단계에서 완전히 숨김 -> Gone 상태로 만듦
        }
    )

    fun Modifier.gone(isGone: Boolean): Modifier = this.then(
        if (isGone) Modifier.layout { _, constraints ->
            layout(0, 0) {}
        }
        else Modifier
    )

    fun Modifier.invisible(isInvisible: Boolean): Modifier = this.then(
        if (isInvisible) {
            Modifier.alpha(0f) // 보이지 않게 처리
                .pointerInput(Unit) {} // 터치 등 상호작용 차단
        }
        else Modifier
    )
}
