package com.hero.z_market.ui.screen.category.goods

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.hero.z_market.domain.entity.GoodsEntity
import com.hero.z_market.ui.preview.goods.GoodsListPreviewParameterProvider
import com.hero.z_market.ui.theme.ZMarketTheme
import kotlinx.coroutines.flow.flowOf

@Composable
fun GoodsListScreen(
    goods: LazyPagingItems<GoodsEntity>,
    onClicked: (GoodsEntity) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth().heightIn(max = 550.dp)
    ) {
        items(count = goods.itemCount) { index ->
            val item = goods[index]
            if (item != null) {
                GoodsItem(
                    goods = item,
                    modifier = Modifier.padding(4.dp),
                    onClicked = onClicked,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GoodsListScreenPreview(
    @PreviewParameter(GoodsListPreviewParameterProvider::class)
    goodsList: List<GoodsEntity>
) {
    val goodsPagingItems = flowOf(PagingData.from(goodsList)).collectAsLazyPagingItems()

    ZMarketTheme {
        GoodsListScreen(goodsPagingItems, onClicked = {})
    }
}
