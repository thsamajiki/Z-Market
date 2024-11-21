package com.hero.z_market.domain.entity

data class ChildCategoryEntity(
    val childCategorySeq: Int, // 하위 분류 일련 번호
    val childCategoryName: String, // 분류명 Enum: [배추,상추,깻잎, 양파,대파,마늘]}]
    val parentCategorySeq: Int, // 상위 분류 일련 번호
    val childCategoryCode: String, // 하위 분류 코드
    val childCategoryLevel: String, // 하위 분류 레벨 Enum: [대분류, 중분류]
    var isSelected: Boolean
)
