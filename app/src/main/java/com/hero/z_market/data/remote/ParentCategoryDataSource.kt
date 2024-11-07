package com.hero.z_market.data.remote

import com.hero.z_market.data.response.ListResultAppDispClasInfoDTO
import com.hero.z_market.network.ParentCategoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ParentCategoryDataSource {
    suspend fun fetchParentCategoryList(): ListResultAppDispClasInfoDTO
}

class ParentCategoryDataSourceImpl @Inject constructor(
    private val parentCategoryService: ParentCategoryService
): ParentCategoryDataSource {
    override suspend fun fetchParentCategoryList(): ListResultAppDispClasInfoDTO {
        return withContext(Dispatchers.IO) {
            parentCategoryService.fetchParentCategoryList()
        }
    }
}
