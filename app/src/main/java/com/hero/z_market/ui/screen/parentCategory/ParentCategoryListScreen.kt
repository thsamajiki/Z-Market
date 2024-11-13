package com.hero.z_market.ui.screen.parentCategory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
import com.hero.z_market.domain.model.ParentCategoryModel
import com.hero.z_market.ui.preview.parentCategory.ParentCategoryListPreviewParameterProvider
import com.hero.z_market.ui.theme.ZMarketTheme

@Composable
fun ParentCategoryListScreen(
    parentCategoryList: List<ParentCategoryModel>,
    onClicked: (ParentCategoryModel) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier.fillMaxWidth().heightIn(max = 1000.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(10.dp, 10.dp)
    ) {
        items(count = parentCategoryList.size) { index ->
            val item = parentCategoryList[index]
            ParentCategoryItem(
                parentCategory = item,
                modifier = Modifier.padding(4.dp),
                onClicked,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ParentCategoryListScreenPreview(
    @PreviewParameter(ParentCategoryListPreviewParameterProvider::class)
    parentCategoryList: List<ParentCategoryModel>
) {
    ZMarketTheme {
        ParentCategoryListScreen(parentCategoryList, onClicked = {})
    }
}
