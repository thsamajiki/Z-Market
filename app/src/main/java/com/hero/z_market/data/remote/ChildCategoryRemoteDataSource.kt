package com.hero.z_market.data.remote

import com.hero.z_market.data.response.SingleResultAppDispClasInfoBySubDispClasInfoDTO
import com.hero.z_market.network.ChildCategoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ChildCategoryRemoteDataSource {
    suspend fun fetchChildCategoryList(parentCategorySeq: Int): SingleResultAppDispClasInfoBySubDispClasInfoDTO
}

class ChildCategoryRemoteDataSourceImpl @Inject constructor(
    private val childCategoryService: ChildCategoryService
): ChildCategoryRemoteDataSource {
    override suspend fun fetchChildCategoryList(parentCategorySeq: Int): SingleResultAppDispClasInfoBySubDispClasInfoDTO {
        return withContext(Dispatchers.IO) {
            childCategoryService.fetchChildCategoryList(parentCategorySeq)
        }
    }
}
