package com.hero.z_market.data.response

import com.google.gson.annotations.SerializedName
import com.hero.z_market.domain.model.ParentCategoryClassifiedModel

data class ListResultAppDispClasInfoDTO(
    val data: List<AppDispClasInfoDTO>,
    val message: String?
)


data class AppDispClasInfoDTO(
    @SerializedName("dispClasSeq") val dispClasSeq: Int, // 전시 카테고리 식별자
    @SerializedName("dispClasNm") val dispClasNm: String, // 전시 카테고리 대분류명
    @SerializedName("dispClasImgPath") val dispClasImgPath: String, // 전시 분류 이미지 경로
    @SerializedName("dispClasCd") val dispClasCd: String, // 전시 분류 코드
)


fun AppDispClasInfoDTO.toEntity(): ParentCategoryClassifiedModel {
    return ParentCategoryClassifiedModel(
        dispClasSeq = dispClasSeq,
        dispClasNm = dispClasNm,
        dispClasImgPath = dispClasImgPath,
        dispClasCd = dispClasCd
    )
}