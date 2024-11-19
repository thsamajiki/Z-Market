package com.hero.z_market.data.remote

import com.hero.z_market.data.response.ListResultAppDispClasInfoDTO
import com.hero.z_market.network.ParentCategoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ParentCategoryRemoteDataSource {
    suspend fun fetchParentCategoryList(): ListResultAppDispClasInfoDTO
}

class ParentCategoryRemoteDataSourceImpl @Inject constructor(
    private val parentCategoryService: ParentCategoryService
): ParentCategoryRemoteDataSource {
    override suspend fun fetchParentCategoryList(): ListResultAppDispClasInfoDTO {
        return withContext(Dispatchers.IO) {
            parentCategoryService.fetchParentCategoryList()
        }
    }
}
