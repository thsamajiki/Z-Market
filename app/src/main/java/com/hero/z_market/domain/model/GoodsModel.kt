package com.hero.z_market.domain.model

import com.hero.z_market.data.response.LowerBadge
import com.hero.z_market.data.response.UpperBadge

data class GoodsModel(
    val goodsSeq: Int, // 상품 번호
    val optionYesNo: String, // Enum:[Y, N]
    val goodsCode: String, // 상품 코드
    val goodsName: String, // 상품명
    val goodsStatus: String, // 판매 상태, 주문 내역 쪽에서는 판매 종료도 다 조회 가능함 Enum:[판매중, 일시 품절, 판매 종료]
    val salePrice: Int, // 판매 가격
    val discountedPrice: Int, // 할인 가격
    val goodsGroupCode: String, // 상품 그룹 코드
    val imgPath: String, //  이미지 경로
    val maxBuyPossibleCountQuantity: Int, // 최대 구매 수량**
    val minBuyPossibleCountQuantity: Int, // 최소 구매 수량**
    val discountedPercent: Int?,
    val adultAuthRequestYesNo: String,
    val upperBadge: UpperBadge?,
    val lowerBadgeList: List<LowerBadge?>,
)
