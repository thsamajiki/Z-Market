package com.hero.z_market.ui.screen.childCategory

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.hero.z_market.R
import com.hero.z_market.domain.model.ParentCategoryModel
import com.hero.z_market.ui.preview.parentCategory.ParentCategoryPreviewParameterProvider
import com.hero.z_market.ui.theme.ZMarketTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildCategoryGoodsListTopAppBar(
    parentCategoryModel: ParentCategoryModel?,
    onBackClick: () -> Unit,
) {
    val context = LocalContext.current

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(White),
        title = {
            Text(
                text = parentCategoryModel?.parentCategoryName ?: "알 수 없음",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back to MainScreen"
                )
            }
        },
        actions = {
            IconButton(onClick = { Toast.makeText(context, "개발 예정", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_search),
                    contentDescription = "Search",
                    tint = Color(0xFF868A93)
                )
            }
            IconButton(onClick = { Toast.makeText(context, "개발 예정", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_menu_cart),
                    contentDescription = "Cart",
                    tint = Color(0xFF868A93)
                )
            }
        })
}


@Composable
@Preview(showBackground = true)
fun ChildCategoryGoodsListTopAppBarPreview(
    @PreviewParameter(ParentCategoryPreviewParameterProvider::class, limit = 5)
    parentCategory: ParentCategoryModel?
) {
    ZMarketTheme {
        ChildCategoryGoodsListTopAppBar(parentCategory, onBackClick= {})
    }
}
