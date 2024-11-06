package com.hero.z_market.ui.preview.childCategory

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.hero.z_market.domain.model.ChildCategoryModel

class ChildCategoryListPreviewParameterProvider :
    PreviewParameterProvider<List<ChildCategoryModel>> {
    override val values = sequenceOf(
        listOf(
            ChildCategoryModel(
                childCategorySeq = 0,
                childCategoryName = "상품 전체",
                parentCategorySeq = 62,
                childCategoryCode = "DPDCM23091",
                childCategoryLevel = "중분류",
                isSelected = true,
            ),
            ChildCategoryModel(
                childCategorySeq = 52,
                childCategoryName = "채소과일",
                parentCategorySeq = 62,
                childCategoryCode = "DPDCM23091",
                childCategoryLevel = "중분류",
                isSelected = false,
            ),
            ChildCategoryModel(
                childCategorySeq = 53,
                childCategoryName = "농축수산물",
                parentCategorySeq = 63,
                childCategoryCode = "DPDCM23091",
                childCategoryLevel = "중분류",
                isSelected = false,
            ),
            ChildCategoryModel(
                childCategorySeq = 54,
                childCategoryName = "식기",
                parentCategorySeq = 64,
                childCategoryCode = "DPDCM23091",
                childCategoryLevel = "중분류",
                isSelected = false,
            ),
            ChildCategoryModel(
                childCategorySeq = 55,
                childCategoryName = "유제품",
                parentCategorySeq = 65,
                childCategoryCode = "DPDCM23091",
                childCategoryLevel = "중분류",
                isSelected = false,
            ),
        )
    )
}
