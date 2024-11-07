package com.hero.z_market.ui.screen.childCategory

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

    Scaffold(
        topBar = {
            ChildCategoryGoodsListTopAppBar(
                parentCategory,
                onBackClick = { (context as? Activity)?.finish() })
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val parentCategorySeq = childCategoryList.firstOrNull()?.parentCategorySeq ?: 0
            val headerItem = ChildCategoryModel(
                0, "상품 전체", parentCategorySeq, "", "", true
            )
            val allChildCategories = mutableListOf<ChildCategoryModel>().apply {
                add(headerItem)
                addAll(childCategoryList)
            }
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

            PaginationInfoScreen(pagination)

            GoodsSortChipGroupScreen(vm)

            GoodsListScreen(
                goods = vm.goods.collectAsLazyPagingItems(),
                onClicked = {}
            )
        }
    }
}
