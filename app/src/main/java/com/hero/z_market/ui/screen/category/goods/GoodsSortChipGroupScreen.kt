package com.hero.z_market.ui.screen.category.goods

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hero.z_market.domain.enum.GoodsSort
import com.hero.z_market.ui.utils.ChipGroup
import com.hero.z_market.ui.utils.ChipState
import com.hero.z_market.ui.utils.ChipStyle
import com.hero.z_market.ui.viewmodel.ChildCategoryGoodsListViewModel

@Composable
fun GoodsSortChipGroupScreen(
    vm: ChildCategoryGoodsListViewModel = hiltViewModel()
) {
    val selectedChipStateList = remember {
        mutableStateListOf(
            ChipState(GoodsSort.RECOMMENDED.value, mutableStateOf(true)),
            ChipState(GoodsSort.BOUGHT.value, mutableStateOf(false)),
            ChipState(GoodsSort.ASCENDING.value, mutableStateOf(false)),
            ChipState(GoodsSort.DESCENDING.value, mutableStateOf(false))
        )
    }

    ChipGroup(
        modifier = Modifier.padding(horizontal = 20.dp),
        chipStateList = selectedChipStateList,
        chipStyle = ChipStyle(
            selectedColor = Transparent,
            unselectedColor = Transparent,
            chipTextStyle = MaterialTheme.typography.bodyMedium,
            selectedTextColor = Black,
            unselectedTextColor = LightGray,
        ),
        onChipClicked = { _, isSelected, index ->
            val selectedChip = selectedChipStateList[index]
            selectedChip.isSelected.value = !isSelected

            vm.setSortValue(selectedChip.labelText)
        }
    )
}
