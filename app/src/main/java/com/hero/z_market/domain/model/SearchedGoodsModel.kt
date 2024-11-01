package com.hero.z_market.domain.model

import com.hero.z_market.data.response.LowerBadge
import com.hero.z_market.data.response.UpperBadge

data class SearchedGoodsModel(
    val goodsInfoSeq: Int, // 상품 번호**
    val dispYn: String, // Enum:[Y, N]**
    val goodsCd: String, // 상품 코드**
    val goodsDispNm: String, // 상품명**
    val goodsStat: String, // 판매 상태, 주문 내역 쪽에서는 판매 종료도 다 조회 가능함 Enum:[판매중, 일시품절, 판매종료]
    val slePrice: Int, // ($int32) 판매 가격**
    val dcPrice: Int, // ($int32) 할인 가격
    val goodsGroupCd: String, // **상품 그룹 코드**
    val imgPath: String, //  **이미지 경로**
    val maxBuyPsblCntQty: Int, // ($int32) 최대 구매 수량**
    val minBuyPsblCntQty: Int, // ($int32) 최소 구매 수량**
    val dcPercent: Int?,
    val adultAuthRequestYn: String,
    val upperBadge: UpperBadge?,
    val lowerBadgeList: List<LowerBadge?>,
)