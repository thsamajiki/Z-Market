package com.hero.z_market.ui.screen.category.childCategory

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.hero.z_market.domain.entity.ChildCategoryEntity
import com.hero.z_market.ui.preview.childCategory.ChildCategoryListPreviewParameterProvider
import com.hero.z_market.ui.theme.ZMarketTheme

@Composable
fun ChildCategoryListScreen(
    childCategoryList: List<ChildCategoryEntity>,
    selectedCategory: ChildCategoryEntity?,
    onClicked: (ChildCategoryEntity) -> Unit
) {
    var selectedCategoryState = remember { mutableStateOf(selectedCategory) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxWidth().heightIn(max = 400.dp),
    ) {
        items(count = childCategoryList.size) { index ->
            val item = childCategoryList[index]
            val isSelected = item.childCategorySeq == selectedCategoryState.value?.childCategorySeq

            // 아이템의 위치에 따라 테두리를 다르게 설정
            val borderModifier = Modifier.drawBehind {
                val strokeWidth = 0.5.dp.toPx()
                val color = LightGray

                // 위쪽 테두리
                if (index < childCategoryList.size - childCategoryList.size % 3) { // 첫 번째 행인 경우에만 위쪽 테두리
                    drawLine(
                        color = color,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = strokeWidth
                    )
                }

                // 오른쪽 테두리
                drawLine(
                    color = color,
                    start = Offset(size.width, 0f),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )

                // 아래쪽 테두리
                drawLine(
                    color = color,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth / 2.0f
                )
            }

            ChildCategoryItem(
                childCategory = item,
                modifier = borderModifier,
                onClicked = { childCategory ->
                    selectedCategoryState.value = childCategory
                    onClicked(childCategory)
                },
                isSelected = isSelected
            )
        }
        items(count = ((childCategoryList.size / 3) + 1) * 3 - childCategoryList.size) { index ->
            val borderModifier = Modifier.drawBehind {
                val strokeWidth = 0.5.dp.toPx()
                val color = LightGray
                // 오른쪽 테두리
                drawLine(
                    color = color,
                    start = Offset(size.width, 0f),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )

                // 아래쪽 테두리
                if (index % 3 == 0 && index > childCategoryList.size - 3) {
                    drawLine(
                        color = color,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = strokeWidth
                    )
                }
            }

            ChildCategoryItem(
                childCategory = selectedCategory?.copy(
                    childCategorySeq = 0,
                    childCategoryName = "",
                    isSelected = false
                ) ?: ChildCategoryEntity(
                    0, "", 0, "", "", false
                ),
                modifier = borderModifier,
                onClicked = {},
                isSelected = false
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ChildCategoryListScreenPreview(
    @PreviewParameter(ChildCategoryListPreviewParameterProvider::class)
    childCategoryList: List<ChildCategoryEntity>
) {
    ZMarketTheme {
        ChildCategoryListScreen(childCategoryList, childCategoryList[0], onClicked = {})
    }
}
