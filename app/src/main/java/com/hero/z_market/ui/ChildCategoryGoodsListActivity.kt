package com.hero.z_market.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hero.z_market.domain.enum.GoodsSort
import com.hero.z_market.domain.entity.ParentCategoryEntity
import com.hero.z_market.ui.MainActivity.Companion.PARENT_CATEGORY
import com.hero.z_market.ui.screen.childCategory.ChildCategoryGoodsListScreen
import com.hero.z_market.ui.theme.ZMarketTheme
import com.hero.z_market.ui.viewmodel.ChildCategoryGoodsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildCategoryGoodsListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZMarketTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val vm: ChildCategoryGoodsListViewModel by viewModels()

                    val parentCategory = getParentCategory()

                    ChildCategoryGoodsListScreen(vm, parentCategory)

                    LaunchedEffect(parentCategory) { fetchGoodsList(vm, parentCategory) }
                }
            }
        }
    }

    fun fetchGoodsList(
        vm: ChildCategoryGoodsListViewModel,
        parentCategory: ParentCategoryEntity?,
    ) {
        val parentCategorySeq = parentCategory?.parentCategorySeq
        vm.setParentCategorySeqValue(parentCategorySeq)
        vm.setChildCategorySeqValue(0)
        vm.setSortValue(GoodsSort.RECOMMENDED.value)

        vm.fetchChildCategoryList(vm.parentCategorySeq.value)
        vm.fetchPaginationInfo(
            parentCategorySeq = parentCategorySeq ?: 0,
            childCategorySeq = 0,
            page = 0,
            size = 20,
            query = vm.sortValue.value
        )
    }

    private fun getParentCategory(): ParentCategoryEntity? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra<ParentCategoryEntity>(
                PARENT_CATEGORY,
                ParentCategoryEntity::class.java
            )
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<ParentCategoryEntity>(PARENT_CATEGORY)
        }
    }

    companion object {
        fun getIntent(
            context: Context,
            parentCategoryEntity: ParentCategoryEntity,
        ): Intent {
            return Intent(context, ChildCategoryGoodsListActivity::class.java).apply {
                putExtra(PARENT_CATEGORY, parentCategoryEntity)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChildCategoryGoodsListScreenPreview() {
    ZMarketTheme {
//        ChildCategoryGoodsListScreen()
    }
}
