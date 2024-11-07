package com.hero.z_market.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hero.z_market.data.response.AppGoodsInfoDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GoodsPagingSource(
    private val goodsDataSource: GoodsDataSource,
    private val parentCategorySeq: Int,
    private val childCategorySeq: Int,
    private val query: String,
) : PagingSource<Int, AppGoodsInfoDTO>() {
    override fun getRefreshKey(state: PagingState<Int, AppGoodsInfoDTO>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition)
        return anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AppGoodsInfoDTO> {
        val page = params.key ?: INITIAL_KEY

        return withContext(Dispatchers.IO) {
            val response = goodsDataSource.fetchGoods(
                parentCategorySeq,
                childCategorySeq,
                page,
                params.loadSize,
                query,
            )

            LoadResult.Page(
                data = response.data,
                prevKey = if (page == INITIAL_KEY) null else page - 1,
                nextKey = if (response.data.isNotEmpty()) {
                    page + 1
                } else {
                    null
                }
            )
        }
    }

    companion object {
        const val INITIAL_KEY = 0
    }
}
