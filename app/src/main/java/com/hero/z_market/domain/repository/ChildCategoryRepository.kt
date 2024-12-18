package com.hero.z_market.domain.repository

import com.hero.z_market.domain.entity.ChildCategoryEntity
import kotlinx.coroutines.flow.Flow

interface ChildCategoryRepository {
    suspend fun fetchChildCategoryList(parentCategorySeq: Int): Flow<List<ChildCategoryEntity>>
}
