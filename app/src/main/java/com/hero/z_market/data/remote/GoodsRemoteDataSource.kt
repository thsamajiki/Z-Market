package com.hero.z_market.data.remote

import com.hero.z_market.data.response.PageResponseAppGoodsInfoDTO
import com.hero.z_market.network.GoodsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GoodsRemoteDataSource {
    suspend fun fetchGoods(parentCategorySeq: Int,
                           childCategorySeq: Int,
                           page: Int,
                           size: Int,
                           query: String,): PageResponseAppGoodsInfoDTO
}

class GoodsRemoteDataSourceImpl @Inject constructor(
    private val goodsService: GoodsService
): GoodsRemoteDataSource {
    override suspend fun fetchGoods(
        parentCategorySeq: Int,
        childCategorySeq: Int,
        page: Int,
        size: Int,
        query: String,
    ): PageResponseAppGoodsInfoDTO {
        return withContext(Dispatchers.IO) {
            goodsService.fetchGoods(
                parentCategorySeq,
                childCategorySeq,
                page,
                size,
                query,
            )
        }
    }
}
