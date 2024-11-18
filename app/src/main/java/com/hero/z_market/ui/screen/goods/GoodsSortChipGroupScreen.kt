package com.hero.z_market.ui.screen.goods

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hero.z_market.domain.enum.GoodsSort
import com.hero.z_market.ui.viewmodel.ChildCategoryGoodsListViewModel

@Composable
fun GoodsSortChipGroupScreen(
    vm: ChildCategoryGoodsListViewModel
) {
    var selectedChipIndex = remember { mutableIntStateOf(0) } // 선택된 Chip의 인덱스 (-1은 아무것도 선택되지 않음을 의미)

    Row(
        modifier = Modifier.padding(start = 10.dp),
    ) {
        GoodsSortChip(
            vm,
            isSelected = selectedChipIndex.intValue == 0
        ) { selectedChipIndex.intValue = 0 }
        GoodsSortChip(
            vm,
            GoodsSort.BOUGHT,
            isSelected = selectedChipIndex.intValue == 1
        ) { selectedChipIndex.intValue = 1 }
        GoodsSortChip(
            vm,
            GoodsSort.ASCENDING,
            isSelected = selectedChipIndex.intValue == 2
        ) { selectedChipIndex.intValue = 2 }
        GoodsSortChip(
            vm,
            GoodsSort.DESCENDING,
            isSelected = selectedChipIndex.intValue == 3
        ) { selectedChipIndex.intValue = 3 }
    }
}
