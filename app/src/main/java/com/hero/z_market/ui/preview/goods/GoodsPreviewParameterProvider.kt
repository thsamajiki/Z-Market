package com.hero.z_market.ui.preview.goods

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.hero.z_market.data.response.LowerBadge
import com.hero.z_market.data.response.UpperBadge
import com.hero.z_market.domain.entity.GoodsEntity

class GoodsPreviewParameterProvider : PreviewParameterProvider<GoodsEntity> {
    override val values = sequenceOf(
        GoodsEntity(
            goodsSeq = 1001,
            optionYesNo = "Y",
            goodsCode = "DPDCL21031",
            goodsName = "사과",
            goodsStatus = "판매중",
            salePrice = 2000,
            discountedPrice = 1600,
            goodsGroupCode = "DPDCM23091",
            imgPath = "https://media.lordicon.com/icons/wired/flat/543-apple.svg",
            maxBuyPossibleCountQuantity = 50,
            minBuyPossibleCountQuantity = 10,
            discountedPercent = 20,
            adultAuthRequestYesNo = "N",
            upperBadge = UpperBadge("good", "Red", "Pink"),
            lowerBadgeList = listOf(LowerBadge("not bad", "Red", "Pink")),
        ),
        GoodsEntity(
            goodsSeq = 1002,
            optionYesNo = "Y",
            goodsCode = "DPDCL21032",
            goodsName = "배",
            goodsStatus = "판매중",
            salePrice = 1800,
            discountedPrice = 1800,
            goodsGroupCode = "DPDCM23092",
            imgPath = "https://cdn-icons-png.flaticon.com/512/123/123239.png",
            maxBuyPossibleCountQuantity = 50,
            minBuyPossibleCountQuantity = 10,
            discountedPercent = 0,
            adultAuthRequestYesNo = "N",
            upperBadge = UpperBadge("good", "Yellow", "White"),
            lowerBadgeList = listOf(LowerBadge("not bad", "Yellow", "White")),
        ),
        GoodsEntity(
            goodsSeq = 1003,
            optionYesNo = "Y",
            goodsCode = "DPDCL21033",
            goodsName = "포도",
            goodsStatus = "판매중",
            salePrice = 2000,
            discountedPrice = 1800,
            goodsGroupCode = "DPDCM23092",
            imgPath = "https://www.shutterstock.com/image-vector/this-image-showcases-single-bunch-600nw-2478676795.jpg",
            maxBuyPossibleCountQuantity = 50,
            minBuyPossibleCountQuantity = 10,
            discountedPercent = 10,
            adultAuthRequestYesNo = "N",
            upperBadge = UpperBadge("good", "Purple", "White"),
            lowerBadgeList = listOf(LowerBadge("not bad", "Purple", "White")),
        ),
        GoodsEntity(
            goodsSeq = 1004,
            optionYesNo = "Y",
            goodsCode = "DPDCL21034",
            goodsName = "딸기",
            goodsStatus = "판매중",
            salePrice = 2000,
            discountedPrice = 1800,
            goodsGroupCode = "DPDCM23092",
            imgPath = "https://cdn-icons-png.flaticon.com/512/7315/7315472.png",
            maxBuyPossibleCountQuantity = 50,
            minBuyPossibleCountQuantity = 10,
            discountedPercent = 10,
            adultAuthRequestYesNo = "N",
            upperBadge = UpperBadge("good", "Red", "White"),
            lowerBadgeList = listOf(LowerBadge("not bad", "Red", "White")),
        ),
    )
}
