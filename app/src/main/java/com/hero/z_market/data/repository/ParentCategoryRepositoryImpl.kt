package com.hero.z_market.data.repository

import com.hero.z_market.data.remote.ParentCategoryDataSource
import com.hero.z_market.data.response.toEntity
import com.hero.z_market.domain.model.ParentCategoryModel
import com.hero.z_market.domain.repository.ParentCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ParentCategoryRepositoryImpl @Inject constructor(
    private val parentCategoryDataSource: ParentCategoryDataSource,
) : ParentCategoryRepository {
    override suspend fun fetchParentCategoryList(): List<ParentCategoryModel> {
        return withContext(Dispatchers.IO) {
            parentCategoryDataSource.fetchParentCategoryList().data.map {
                it.toEntity()
            }
        }
    }
}
