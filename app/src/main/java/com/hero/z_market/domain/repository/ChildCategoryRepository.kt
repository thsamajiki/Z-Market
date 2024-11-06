package com.hero.z_market.domain.repository

import com.hero.z_market.domain.model.ChildCategoryModel
import kotlinx.coroutines.flow.Flow

interface ChildCategoryRepository {
    suspend fun fetchChildCategoryList(parentCategorySeq: Int): Flow<List<ChildCategoryModel>>
}
