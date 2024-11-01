package com.hero.z_market.domain.model

data class SubCategoryClassifiedModel(
    val dispClasSeq: Int, // 전시 분류 일련 번호
    val subDispClasNm: String, // 전시 분류명 Enum: [배추,상추,깻잎, 양파,대파,마늘]}]
    val prntsDispClasSeq: Int, // 부모 전시 분류 일련 번호
    val dispClasCd: String, // 전시 분류 코드
    val dispClasLvl: String, // 전시 분류 레벨 Enum: [대분류, 중분류]
    var isSelected: Boolean
)