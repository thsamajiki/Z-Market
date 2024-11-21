package com.hero.z_market.data.response

import com.google.gson.annotations.SerializedName
import com.hero.z_market.domain.entity.ChildCategoryEntity

data class SingleResultAppDispClasInfoBySubDispClasInfoDTO(
    @SerializedName("data") val childCategoryInfoList: AppDispClasInfoBySubDispClasInfoDTO,
    val message: String?
)

// 카테고리 하위 목록 조회
data class AppDispClasInfoBySubDispClasInfoDTO(
    @SerializedName("dispClasNm") val parentCategoryName: String,
    @SerializedName("appSubDispClasInfoList") val childCategoryInfoList: List<AppSubDispClasInfoDTO>
)

data class AppSubDispClasInfoDTO(
    @SerializedName("dispClasSeq") val childCategorySeq: Int, // 전시 분류 일련 번호
    @SerializedName("subDispClasNm") val childCategoryName: String, // 전시 분류명 Enum: [배추,상추,깻잎, 양파,대파,마늘]}]
    @SerializedName("prntsDispClasSeq") val parentCategorySeq: Int, // 부모 전시 분류 일련 번호
    @SerializedName("dispClasCd") val childCategoryCode: String, // 전시 분류 코드
    @SerializedName("dispClasLvl") val childCategoryLevel: String, // 전시 분류 레벨 Enum: [대분류, 중분류]
)

fun AppSubDispClasInfoDTO.toEntity(): ChildCategoryEntity {
    return ChildCategoryEntity(
        childCategorySeq = childCategorySeq,
        childCategoryName = childCategoryName,
        parentCategorySeq = parentCategorySeq,
        childCategoryCode = childCategoryCode,
        childCategoryLevel = childCategoryLevel,
        isSelected = false
    )
}
