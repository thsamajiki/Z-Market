package com.hero.z_market.domain.repository

import com.hero.z_market.domain.model.ParentCategoryModel

interface ParentCategoryRepository {
    suspend fun fetchParentCategoryList(): List<ParentCategoryModel>
}


