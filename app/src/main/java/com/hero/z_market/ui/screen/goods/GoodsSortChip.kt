package com.hero.z_market.ui.screen.goods

import android.graphics.Typeface
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hero.z_market.R
import com.hero.z_market.domain.enum.GoodsSort
import com.hero.z_market.ui.viewmodel.ChildCategoryGoodsListViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GoodsSortChip(
    vm: ChildCategoryGoodsListViewModel,
    goodsSort: GoodsSort = GoodsSort.RECOMMENDED,
    isSelected: Boolean,
    onSelected: () -> Unit,
) {
    FilterChip(
        onClick = {
            onSelected() // 선택된 Chip의 인덱스를 업데이트
            vm.setSortValue(goodsSort.value)
        },
        label = {
            Text(
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                fontSize = 12.sp,
                color = if (isSelected) Black else Gray,
                text = goodsSort.value,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
            )
        },
        selected = isSelected,
        leadingIcon = if (isSelected) {
            {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_selected_order),
                    contentDescription = "Selected icon",
                    modifier = Modifier.size(4.dp),
                    tint = Blue
                )
            }
        } else {
            {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_unselected_order),
                    contentDescription = "Unselected icon",
                    modifier = Modifier.size(4.dp),
                    tint = Gray
                )
            }
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Transparent,
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = Transparent,
            selectedBorderColor = Transparent,
            disabledBorderColor = Transparent,
        )
    )
}
