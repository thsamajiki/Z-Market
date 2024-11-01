package com.hero.z_market.data.response

import com.google.gson.annotations.SerializedName
import com.hero.z_market.domain.model.SubCategoryClassifiedModel

data class SingleResultAppDispClasInfoBySubDispClasInfoDTO(
    @SerializedName("data") val appSubDispClasInfoList: AppDispClasInfoBySubDispClasInfoDTO,
    @SerializedName("message") val message: String?
)

// 카테고리 하위 목록 조회
data class AppDispClasInfoBySubDispClasInfoDTO(
    @SerializedName("dispClasNm") val dispClasNm: String,
    @SerializedName("appSubDispClasInfoList") val appSubDispClasInfoList: List<AppSubDispClasInfoDTO>
)

data class AppSubDispClasInfoDTO(
    @SerializedName("dispClasSeq") val dispClasSeq: Int, // 전시 분류 일련 번호
    @SerializedName("subDispClasNm") val subDispClasNm: String, // 전시 분류명 Enum: [배추,상추,깻잎, 양파,대파,마늘]}]
    @SerializedName("prntsDispClasSeq") val prntsDispClasSeq: Int, // 부모 전시 분류 일련 번호
    @SerializedName("dispClasCd") val dispClasCd: String, // 전시 분류 코드
    @SerializedName("dispClasLvl") val dispClasLvl: String, // 전시 분류 레벨 Enum: [대분류, 중분류]
)

fun AppSubDispClasInfoDTO.toEntity(): SubCategoryClassifiedModel {
    return SubCategoryClassifiedModel(
        dispClasSeq = dispClasSeq,
        subDispClasNm = subDispClasNm,
        prntsDispClasSeq = prntsDispClasSeq,
        dispClasCd = dispClasCd,
        dispClasLvl = dispClasLvl,
        isSelected = false
    )
}