package com.hero.z_market.domain.repository

import androidx.paging.PagingData
import com.hero.z_market.data.response.PaginationItem
import com.hero.z_market.domain.entity.GoodsEntity
import kotlinx.coroutines.flow.Flow

interface GoodsRepository {
    suspend fun fetchGoods(
        parentCategorySeq: Int,
        childCategorySeq: Int,
        page: Int,
        size: Int,
        query: String,
    ): Flow<PagingData<GoodsEntity>>

    suspend fun fetchPaginationInfo(
        parentCategorySeq: Int,
        childCategorySeq:Int,
        page: Int,
        size: Int,
        query: String
    ): Flow<PaginationItem>
}
