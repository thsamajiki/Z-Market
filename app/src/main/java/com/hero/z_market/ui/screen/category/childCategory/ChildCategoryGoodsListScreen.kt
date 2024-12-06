package com.hero.z_market.ui.screen.category.childCategory

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.hero.z_market.data.response.PaginationItem
import com.hero.z_market.domain.entity.ChildCategoryEntity
import com.hero.z_market.domain.entity.GoodsEntity
import com.hero.z_market.domain.entity.ParentCategoryEntity
import com.hero.z_market.ui.screen.category.goods.GoodsListScreen
import com.hero.z_market.ui.screen.category.goods.GoodsSortChipGroupScreen
import com.hero.z_market.ui.state.UiState
import com.hero.z_market.ui.utils.ToastExtension.PutIntoCartToast
import com.hero.z_market.ui.viewmodel.ChildCategoryGoodsListViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun ChildCategoryGoodsListScreen(
    vm: ChildCategoryGoodsListViewModel = hiltViewModel(),
    parentCategory: ParentCategoryEntity?,
) {
    val fetchChildCategoryListUiState by vm.fetchChildCategoryListUiState.collectAsState()
    val fetchPaginationUiState by vm.fetchPaginationUiState.collectAsState()
    val fetchGoodsListUiState by vm.fetchGoodsListUiState.collectAsState()

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

    val snackBarHostState = remember { SnackbarHostState() }
    val snackBarDuration = 2000L
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            ChildCategoryGoodsListTopAppBar(
                parentCategory,
                onBackClick = { (context as? Activity)?.finish() }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState,
                modifier = Modifier.offset(y = (-20).dp)
            ) { snackBarData ->
                PutIntoCartToast(snackBarData.visuals.message)
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .nestedScroll(nestedScrollConnection, nestedScrollDispatcher)
        ) {
            val parentCategorySeq = childCategoryList.firstOrNull()?.parentCategorySeq ?: 0
            val headerItem = ChildCategoryEntity(
                0, "상품 전체", parentCategorySeq, "", "", true
            )
            val allChildCategories = mutableListOf<ChildCategoryEntity>().apply {
                add(headerItem)
                addAll(childCategoryList)
            }
            item {
                when(fetchChildCategoryListUiState) {
                    is UiState.Success<List<ChildCategoryEntity>> -> {
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
                    is UiState.Failed -> {
                        Toast.makeText(context, "분류 카테고리를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show()
                    }
                    is UiState.Idle -> {}
                }
            }

            stickyHeader {
                Spacer(modifier = Modifier.fillMaxWidth().height(35.dp))
                Column {
                    when(fetchPaginationUiState) {
                        is UiState.Success<PaginationItem> -> {
                            PaginationInfoScreen(pagination)
                        }
                        is UiState.Failed -> {
                            Toast.makeText(context, "페이지 수를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show()
                        }
                        is UiState.Idle -> {
                        }
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
                    GoodsSortChipGroupScreen()
                    Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
                }
            }

            item {
                when (fetchGoodsListUiState) {
                    is UiState.Success<PagingData<GoodsEntity>> -> {
                        GoodsListScreen(
                            goods = vm.goods.collectAsLazyPagingItems(),
                            onClicked = { goods ->
                                coroutineScope.launch {
                                    val job = launch {
                                        snackBarHostState.showSnackbar(goods.goodsName)
                                    }
                                    delay(snackBarDuration)
                                    job.cancel()
                                }
                            }
                        )
                    }
                    is UiState.Failed -> {
                        Toast.makeText(context, "상품 목록을 불러올 수 없습니다.", Toast.LENGTH_SHORT).show()
                    }
                    is UiState.Idle -> {}
                }
            }
        }
    }
}
