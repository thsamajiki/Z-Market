package com.hero.z_market.domain.enum

enum class SearchOrderOption(val order: String) {
    RECOMMENDED("추천순"),
    BOUGHT("판매량순"),
    ASCENDING("낮은가격순"),
    DESCENDING("높은가격순")
}