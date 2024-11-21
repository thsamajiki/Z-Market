package com.hero.z_market.data.repository

import com.hero.z_market.data.remote.ParentCategoryRemoteDataSource
import com.hero.z_market.data.response.toEntity
import com.hero.z_market.domain.entity.ParentCategoryEntity
import com.hero.z_market.domain.repository.ParentCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ParentCategoryRepositoryImpl @Inject constructor(
    private val parentCategoryRemoteDataSource: ParentCategoryRemoteDataSource,
) : ParentCategoryRepository {
    override suspend fun fetchParentCategoryList(): List<ParentCategoryEntity> {
        return withContext(Dispatchers.IO) {
            parentCategoryRemoteDataSource.fetchParentCategoryList().data.map {
                it.toEntity()
            }
        }
    }
}
