package com.hero.z_market.data.remote

import com.hero.z_market.data.response.SingleResultAppDispClasInfoBySubDispClasInfoDTO
import com.hero.z_market.network.ChildCategoryService
import javax.inject.Inject

interface ChildCategoryDataSource {
    suspend fun fetchChildCategoryList(parentCategorySeq: Int): SingleResultAppDispClasInfoBySubDispClasInfoDTO
}

class ChildCategoryDataSourceImpl @Inject constructor(
    private val childCategoryService: ChildCategoryService
): ChildCategoryDataSource {
    override suspend fun fetchChildCategoryList(parentCategorySeq: Int): SingleResultAppDispClasInfoBySubDispClasInfoDTO {
        return childCategoryService.fetchChildCategoryList(parentCategorySeq)
    }
}
