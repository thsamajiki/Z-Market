package com.hero.z_market.domain.repository

import com.hero.z_market.domain.entity.ParentCategoryEntity

interface ParentCategoryRepository {
    suspend fun fetchParentCategoryList(): List<ParentCategoryEntity>
}


