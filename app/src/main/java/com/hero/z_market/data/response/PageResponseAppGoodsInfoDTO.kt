package com.hero.z_market.data.response

import com.google.gson.annotations.SerializedName
import com.hero.z_market.domain.model.SearchedGoodsModel

data class PageResponseAppGoodsInfoDTO(
    val data: List<AppGoodsInfoDTO>,
    val pagination: PaginationDTO,
)

data class AppGoodsInfoDTO(
    @SerializedName("goodsInfoSeq") val goodsInfoSeq: Int, // 상품 번호**
    @SerializedName("dispYn") val dispYn: String, // Enum:[Y, N]**
    @SerializedName("goodsCd") val goodsCd: String, // 상품 코드**
    @SerializedName("goodsDispNm") val goodsDispNm: String, // 상품명**
    @SerializedName("goodsStat") val goodsStat: String, // 판매 상태, 주문 내역 쪽에서는 판매 종료도 다 조회 가능함 Enum:[판매중, 일시품절, 판매종료]
    @SerializedName("slePrice") val slePrice: Int, // ($int32) 판매 가격**
    @SerializedName("dcPrice") val dcPrice: Int, // ($int32) 할인 가격
    @SerializedName("goodsGroupCd") val goodsGroupCd: String, // **상품 그룹 코드**
    @SerializedName("imgPath") val imgPath: String, //  **이미지 경로**
    @SerializedName("maxBuyPsblCntQty") val maxBuyPsblCntQty: Int, // ($int32) 최대 구매 수량**
    @SerializedName("minBuyPsblCntQty") val minBuyPsblCntQty: Int, // ($int32) 최소 구매 수량**
    @SerializedName("dcPercent") val dcPercent: Int?,
    @SerializedName("adultAuthRequestYn") val adultAuthRequestYn: String,
    @SerializedName("upperBadge") val upperBadge: UpperBadge?,
    @SerializedName("lowerBadgeList") val lowerBadgeList: List<LowerBadge?>,
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

fun AppGoodsInfoDTO.toEntity(): SearchedGoodsModel {
    return SearchedGoodsModel(
        goodsInfoSeq = goodsInfoSeq,
        dispYn = dispYn,
        goodsCd = goodsCd,
        goodsDispNm = goodsDispNm,
        goodsStat = goodsStat,
        slePrice = slePrice,
        dcPrice = dcPrice,
        goodsGroupCd = goodsGroupCd,
        imgPath = imgPath,
        maxBuyPsblCntQty = maxBuyPsblCntQty,
        minBuyPsblCntQty = minBuyPsblCntQty,
        dcPercent = dcPercent,
        adultAuthRequestYn = adultAuthRequestYn,
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
    val currentPage: Int = 0, // ($int32)*example:0* 조회된 현재 page.
    val elementSizeOfPage: Int = 0, // ($int32) 요청 page당 element의 수
    val totalElements: Int = 0, // ($int64) 전체 element의 수.
    val totalPage: Int = 0 // ($int32) 전체 page수.
)

fun PaginationDTO.toEntity(): PaginationItem {
    return PaginationItem(
        currentPage = currentPage,
        elementSizeOfPage = elementSizeOfPage,
        totalElements = totalElements,
        totalPage = totalPage
    )
}