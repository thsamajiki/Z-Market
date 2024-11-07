package com.hero.z_market.ui.screen.goods

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hero.z_market.domain.enum.GoodsSort
import com.hero.z_market.ui.viewmodel.ChildCategoryGoodsListViewModel

@Composable
fun GoodsSortChipGroupScreen(
    vm: ChildCategoryGoodsListViewModel
) {
    var selectedChipIndex = remember { mutableStateOf(0) } // 선택된 Chip의 인덱스 (-1은 아무것도 선택되지 않음을 의미)

    Row(
        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
    ) {
        GoodsSortChip(
            vm,
            isSelected = selectedChipIndex.value == 0
        ) { selectedChipIndex.value = 0 }
        GoodsSortChip(
            vm,
            GoodsSort.BOUGHT,
            isSelected = selectedChipIndex.value == 1
        ) { selectedChipIndex.value = 1 }
        GoodsSortChip(
            vm,
            GoodsSort.ASCENDING,
            isSelected = selectedChipIndex.value == 2
        ) { selectedChipIndex.value = 2 }
        GoodsSortChip(
            vm,
            GoodsSort.DESCENDING,
            isSelected = selectedChipIndex.value == 3
        ) { selectedChipIndex.value = 3 }
    }
}
