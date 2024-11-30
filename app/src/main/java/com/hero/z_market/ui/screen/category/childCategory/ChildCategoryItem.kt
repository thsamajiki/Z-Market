package com.hero.z_market.ui.screen.category.childCategory

import android.graphics.Typeface
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hero.z_market.domain.entity.ChildCategoryEntity
import com.hero.z_market.ui.preview.childCategory.ChildCategoryPreviewParameterProvider
import com.hero.z_market.ui.theme.ZMarketTheme

@Composable
fun ChildCategoryItem(
    childCategory: ChildCategoryEntity,
    modifier: Modifier,
    onClicked: (ChildCategoryEntity) -> Unit,
    isSelected: Boolean,
) {
    Card(
        modifier = modifier.clickable {
            onClicked(childCategory)
            childCategory.isSelected = !childCategory.isSelected
        },
        colors = CardDefaults.cardColors(White),
        border = BorderStroke(0.1.dp, LightGray),
        shape = RectangleShape,
    ) {
        Text(
            text = childCategory.childCategoryName,
            modifier = Modifier
                .padding(10.dp, 10.dp, 0.dp, 10.dp)
                .align(Alignment.Start),
            fontFamily = FontFamily(Typeface.SANS_SERIF),
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start,
            color = if (isSelected) Black else Gray,
            fontSize = 12.sp,
            overflow = TextOverflow.Visible,
            maxLines = 2,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ChildCategoryItemPreview(
    @PreviewParameter(ChildCategoryPreviewParameterProvider::class, limit = 5)
    childCategory: ChildCategoryEntity
) {
    ZMarketTheme {
        ChildCategoryItem(
            childCategory = childCategory,
            modifier = Modifier.wrapContentSize(),
            onClicked = {},
            isSelected = childCategory.isSelected
        )
    }
}
