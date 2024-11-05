package com.hero.z_market.domain.repository

import com.hero.z_market.data.remote.ParentCategoryDataSource
import com.hero.z_market.data.response.toEntity
import com.hero.z_market.domain.model.ParentCategoryModel
import javax.inject.Inject

interface ParentCategoryRepository {
    suspend fun fetchParentCategoryList(): List<ParentCategoryModel>
}

class ParentCategoryRepositoryImpl @Inject constructor(
    private val parentCategoryDataSource: ParentCategoryDataSource,
) : ParentCategoryRepository {
    override suspend fun fetchParentCategoryList(): List<ParentCategoryModel> {
        return parentCategoryDataSource.fetchParentCategoryList().data.map {
            it.toEntity()
        }
    }
}
