package com.hero.z_market.data.response

import com.google.gson.annotations.SerializedName
import com.hero.z_market.domain.model.GoodsModel

data class PageResponseAppGoodsInfoDTO(
    val data: List<AppGoodsInfoDTO>,
    val pagination: PaginationDTO,
)

data class AppGoodsInfoDTO(
    @SerializedName("goodsInfoSeq") val goodsSeq: Int, // 상품 번호
    @SerializedName("dispYn") val optionYesNo: String, // Enum:[Y, N]
    @SerializedName("goodsCd") val goodsCode: String, // 상품 코드
    @SerializedName("goodsDispNm") val goodsName: String, // 상품명
    @SerializedName("goodsStat") val goodsStatus: String, // 판매 상태, 주문 내역 쪽에서는 판매 종료도 다 조회 가능함 Enum:[판매중, 일시 품절, 판매 종료]
    @SerializedName("slePrice") val salePrice: Int, // 판매 가격**
    @SerializedName("dcPrice") val discountedPrice: Int, // 할인 가격
    @SerializedName("goodsGroupCd") val goodsGroupCode: String, // 상품 그룹 코드
    val imgPath: String, // 이미지 경로
    @SerializedName("maxBuyPsblCntQty") val maxBuyPossibleCountQuantity: Int, // 최대 구매 수량**
    @SerializedName("minBuyPsblCntQty") val minBuyPossibleCountQuantity: Int, // 최소 구매 수량**
    @SerializedName("dcPercent") val discountedPercent: Int?,
    @SerializedName("adultAuthRequestYn") val adultAuthRequestYesNo: String,
    val upperBadge: UpperBadge?,
    val lowerBadgeList: List<LowerBadge?>,
)

data class UpperBadge(
    val goodsBadgeNm : String,
    val fontColor: String,
    val backgroundColor: String,
)

data class LowerBadge(
    val goodsBadgeNm : String,
    val fontColor: String,
    val backgroundColor: String,
)

fun AppGoodsInfoDTO.toEntity(): GoodsModel {
    return GoodsModel(
        goodsSeq = goodsSeq,
        optionYesNo = optionYesNo,
        goodsCode = goodsCode,
        goodsName = goodsName,
        goodsStatus = goodsStatus,
        salePrice = salePrice,
        discountedPrice = discountedPrice,
        goodsGroupCode = goodsGroupCode,
        imgPath = imgPath,
        maxBuyPossibleCountQuantity = maxBuyPossibleCountQuantity,
        minBuyPossibleCountQuantity = minBuyPossibleCountQuantity,
        discountedPercent = discountedPercent,
        adultAuthRequestYesNo = adultAuthRequestYesNo,
        upperBadge = upperBadge,
        lowerBadgeList = lowerBadgeList,
    )
}

data class PaginationDTO(
    @SerializedName("currentPage") val currentPage: Int, // ($int32)*example:0* 조회된 현재 page.
    @SerializedName("elementSizeOfPage") val elementSizeOfPage: Int, // ($int32) 요청 page당 element의 수
    @SerializedName("totalElements") val totalElements: Int, // ($int64) 전체 element의 수.
    @SerializedName("totalPage") val totalPage: Int // ($int32) 전체 page수.
)

data class PaginationItem(
    val currentPage: Int = 0, // 조회된 현재 page.
    val elementSizeOfPage: Int = 0, // 요청 page 당 element의 수
    val totalElements: Int = 0, // 전체 element의 수.
    val totalPage: Int = 0 // 전체 page 수.
)

fun PaginationDTO.toEntity(): PaginationItem {
    return PaginationItem(
        currentPage = currentPage,
        elementSizeOfPage = elementSizeOfPage,
        totalElements = totalElements,
        totalPage = totalPage
    )
}
