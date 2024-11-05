package com.hero.z_market.ui.preview.parentCategory

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.hero.z_market.domain.model.ParentCategoryModel

class ParentCategoryPreviewParameterProvider : PreviewParameterProvider<ParentCategoryModel> {
    override val values = sequenceOf(
        ParentCategoryModel(
            parentCategorySeq = 62,
            parentCategoryName = "과일/채소",
            parentCategoryImgPath = "https://cdn-icons-png.flaticon.com/512/1625/1625048.png",
            parentCategoryCode = "DPDCH23091",
        ),
        ParentCategoryModel(
            parentCategorySeq = 63,
            parentCategoryName = "고기/정육",
            parentCategoryImgPath = "https://cdn-icons-png.flaticon.com/512/1134/1134447.png",
            parentCategoryCode = "DPDCH23092",
        ),
        ParentCategoryModel(
            parentCategorySeq = 64,
            parentCategoryName = "주방/위생용품",
            parentCategoryImgPath = "https://cdn-icons-png.flaticon.com/512/10426/10426974.png",
            parentCategoryCode = "DPDCH23093",
        ),
        ParentCategoryModel(
            parentCategorySeq = 65,
            parentCategoryName = "음료/생수",
            parentCategoryImgPath = "https://cdn-icons-png.flaticon.com/512/7535/7535493.png",
            parentCategoryCode = "DPDCH23094",
        ),
        ParentCategoryModel(
            parentCategorySeq = 66,
            parentCategoryName = "과자/다과",
            parentCategoryImgPath = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8bSaWm1T7sxuX1HnzN8rVES8yygfKUoeQ2A&s",
            parentCategoryCode = "DPDCH23095",
        ),
        ParentCategoryModel(
            parentCategorySeq = 67,
            parentCategoryName = "주류",
            parentCategoryImgPath = "https://cdn-icons-png.flaticon.com/512/988/988934.png",
            parentCategoryCode = "DPDCH23096",
        ),
        ParentCategoryModel(
            parentCategorySeq = 68,
            parentCategoryName = "해외식품",
            parentCategoryImgPath = "https://cdn-icons-png.flaticon.com/512/3076/3076094.png",
            parentCategoryCode = "DPDCH23097",
        ),
    )
}
