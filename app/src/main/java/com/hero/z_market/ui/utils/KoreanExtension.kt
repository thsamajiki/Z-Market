package com.hero.z_market.ui.utils

object KoreanExtension {
    fun String.setPostPosition(firstPostPosition: String, secondPostPosition: String): String {
        val lastSpell = this.last()

        // 한글의 유니코드 범위를 벗어나는 경우는 그대로 리턴
        if (lastSpell !in '\uAC00'..'\uD7A3') {
            return this
        }

        // 종성 유무에 따라 값 선택
        //  firstValue: "이", "을", "은" (종성 有)
        // secondValue: "가", "를", "는" (종성 無)
        val postPosition = if ((lastSpell.code - 0xAC00) % 28 > 0) firstPostPosition else secondPostPosition

        return this + postPosition
    }
}
