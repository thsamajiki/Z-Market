package com.hero.z_market.domain.usecase

import com.hero.z_market.domain.entity.ParentCategoryEntity
import com.hero.z_market.domain.repository.ParentCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface FetchParentCategoryListUseCase {
    suspend operator fun invoke(): List<ParentCategoryEntity>
}

class FetchParentCategoryListUseCaseImpl @Inject constructor(
    private val repository: ParentCategoryRepository,
) : FetchParentCategoryListUseCase {
    override suspend fun invoke(): List<ParentCategoryEntity> {
        return withContext(Dispatchers.IO) {
            repository.fetchParentCategoryList()
        }
    }
}
