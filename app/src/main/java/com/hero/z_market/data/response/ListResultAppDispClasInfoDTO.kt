package com.hero.z_market.data.response

import com.google.gson.annotations.SerializedName
import com.hero.z_market.domain.entity.ParentCategoryEntity

data class ListResultAppDispClasInfoDTO(
    val data: List<AppDispClasInfoDTO>,
    val message: String?
)


data class AppDispClasInfoDTO(
    @SerializedName("dispClasSeq") val parentCategorySeq: Int, // 부모 카테고리 식별자
    @SerializedName("dispClasNm") val parentCategoryName: String, // 부모 카테고리 대분류명
    @SerializedName("dispClasImgPath") val parentCategoryImgPath: String, // 부모 카테고리 이미지 경로
    @SerializedName("dispClasCd") val parentCategoryCode: String, // 부모 카테고리 코드
)


fun AppDispClasInfoDTO.toEntity(): ParentCategoryEntity {
    return ParentCategoryEntity(
        parentCategorySeq = parentCategorySeq,
        parentCategoryName = parentCategoryName,
        parentCategoryImgPath = parentCategoryImgPath,
        parentCategoryCode = parentCategoryCode
    )
}
