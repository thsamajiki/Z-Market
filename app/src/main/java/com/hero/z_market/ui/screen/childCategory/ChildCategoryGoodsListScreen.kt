package com.hero.z_market.ui.screen.childCategory

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.hero.z_market.domain.model.ChildCategoryModel
import com.hero.z_market.domain.model.ParentCategoryModel
import com.hero.z_market.ui.screen.goods.GoodsListScreen
import com.hero.z_market.ui.screen.goods.GoodsSortChipGroupScreen
import com.hero.z_market.ui.viewmodel.ChildCategoryGoodsListViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun ChildCategoryGoodsListScreen(
    vm: ChildCategoryGoodsListViewModel,
    parentCategory: ParentCategoryModel?,
) {
    val context = LocalContext.current
    var selectedChildCategory = vm.selectedChildCategory.collectAsState()
    val childCategoryList by vm.childCategoryList.collectAsState()
    val pagination by vm.paginationInfo.collectAsState()

    val topBarHeight = 48.dp
    val topBarHeightPx = with(LocalDensity.current) { topBarHeight.roundToPx().toFloat() }
    val topBarOffsetHeightPx = remember { mutableFloatStateOf(0f) }

    val basicState = remember { mutableFloatStateOf(0f) }
    val minBound = -100f
    val maxBound = 100f

    val onNewDelta: (Float) -> Float = { delta ->
        val oldState = basicState.floatValue
        val newState = (basicState.floatValue + delta).coerceIn(minBound, maxBound)
        basicState.floatValue = newState
        newState - oldState
    }

    val nestedScrollDispatcher = remember { NestedScrollDispatcher() }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = topBarOffsetHeightPx.floatValue + delta
                topBarOffsetHeightPx.floatValue = newOffset.coerceIn(-topBarHeightPx, 0f)

                return Offset.Zero
            }

            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                val vertical = available.y
                val weConsumed = onNewDelta(vertical)
                return Offset(x = 0f, y = weConsumed)
            }
        }
    }

    Scaffold(
        topBar = {
            ChildCategoryGoodsListTopAppBar(
                parentCategory,
                onBackClick = { (context as? Activity)?.finish() }
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .nestedScroll(nestedScrollConnection, nestedScrollDispatcher)
        ) {
            val parentCategorySeq = childCategoryList.firstOrNull()?.parentCategorySeq ?: 0
            val headerItem = ChildCategoryModel(
                0, "상품 전체", parentCategorySeq, "", "", true
            )
            val allChildCategories = mutableListOf<ChildCategoryModel>().apply {
                add(headerItem)
                addAll(childCategoryList)
            }
            item {
                ChildCategoryListScreen(
                    childCategoryList = allChildCategories,
                    selectedCategory = selectedChildCategory.value,
                    onClicked = { childCategory ->
                        val parentCategorySeq = childCategory.parentCategorySeq
                        val childCategorySeq = childCategory.childCategorySeq

                        vm.setParentCategorySeqValue(parentCategorySeq)
                        vm.setChildCategorySeqValue(childCategorySeq)
                        vm.fetchPaginationInfo(
                            parentCategorySeq = parentCategorySeq,
                            childCategorySeq = childCategorySeq,
                            0, 20,
                            vm.sortValue.value
                        )
                    },
                )
            }

            stickyHeader {
                Column {
                    PaginationInfoScreen(pagination)
                    GoodsSortChipGroupScreen(vm)
                }
            }

            item {
                GoodsListScreen(
                    goods = vm.goods.collectAsLazyPagingItems(),
                    onClicked = {}
                )
            }
        }
    }
}
