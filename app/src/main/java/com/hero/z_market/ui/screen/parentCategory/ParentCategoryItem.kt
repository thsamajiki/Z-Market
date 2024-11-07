package com.hero.z_market.ui.screen.parentCategory

import android.graphics.Typeface
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hero.z_market.constants.BASE_IMG_URL
import com.hero.z_market.domain.model.ParentCategoryModel
import com.hero.z_market.ui.preview.parentCategory.ParentCategoryPreviewParameterProvider
import com.hero.z_market.ui.theme.ZMarketTheme

@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun ParentCategoryItem(
    parentCategory: ParentCategoryModel,
    modifier: Modifier,
    onClicked: (ParentCategoryModel) -> Unit
) {
    Card(
        modifier = modifier
            .combinedClickable(
                onClick = { onClicked(parentCategory) }
            ),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        colors = CardDefaults.cardColors(White),
        elevation = CardDefaults.cardElevation(1.dp),
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column {
                GlideImage(
                    model = BASE_IMG_URL + parentCategory.parentCategoryImgPath,
                    contentDescription = "ParentCategory",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(2.dp)
                        .align(Alignment.CenterHorizontally),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = parentCategory.parentCategoryName,
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.CenterHorizontally),
                    fontFamily = FontFamily(Typeface.SANS_SERIF),
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Visible,
                    maxLines = 2,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ParentCategoryItemPreview(
    @PreviewParameter(ParentCategoryPreviewParameterProvider::class, limit = 5)
    parentCategory: ParentCategoryModel
) {
    ZMarketTheme {
        ParentCategoryItem(
            parentCategory = parentCategory,
            modifier = Modifier.padding(4.dp),
            onClicked = {}
        )
    }
}
