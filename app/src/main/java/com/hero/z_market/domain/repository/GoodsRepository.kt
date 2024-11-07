package com.hero.z_market.domain.repository

import androidx.paging.PagingData
import com.hero.z_market.data.response.PaginationItem
import com.hero.z_market.domain.model.GoodsModel
import kotlinx.coroutines.flow.Flow

interface GoodsRepository {
    suspend fun fetchGoods(
        parentCategorySeq: Int,
        childCategorySeq: Int,
        page: Int,
        size: Int,
        query: String,
    ): Flow<PagingData<GoodsModel>>

    suspend fun fetchPaginationInfo(
        parentCategorySeq: Int,
        childCategorySeq:Int,
        page: Int,
        size: Int,
        query: String
    ): Flow<PaginationItem>
}
