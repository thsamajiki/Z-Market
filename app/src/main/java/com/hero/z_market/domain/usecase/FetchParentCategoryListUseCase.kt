package com.hero.z_market.domain.usecase

import com.hero.z_market.domain.model.ParentCategoryModel
import com.hero.z_market.domain.repository.ParentCategoryRepository
import javax.inject.Inject

interface FetchParentCategoryListUseCase {
    suspend operator fun invoke(): List<ParentCategoryModel>
}

class FetchParentCategoryListUseCaseImpl @Inject constructor(
    private val repository: ParentCategoryRepository,
) : FetchParentCategoryListUseCase {
    override suspend fun invoke(): List<ParentCategoryModel> {
        return repository.fetchParentCategoryList()
    }
}