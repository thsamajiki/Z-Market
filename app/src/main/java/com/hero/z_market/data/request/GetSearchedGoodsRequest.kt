package com.hero.z_market.data.request

import com.hero.z_market.domain.enum.SearchOrderOption

data class GetSearchedGoodsRequest(
    val dispClasSeq: Int,
    val subDispClasSeq: Int,
    val pageRequest: PageRequest,
    val searchValue: String = SearchOrderOption.RECOMMENDED.order
)