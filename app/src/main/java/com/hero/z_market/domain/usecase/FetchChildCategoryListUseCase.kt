package com.hero.z_market.domain.usecase

import com.hero.z_market.domain.entity.ChildCategoryEntity
import com.hero.z_market.domain.repository.ChildCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface FetchChildCategoryListUseCase {
    suspend fun invoke(parentCategorySeq: Int): Flow<List<ChildCategoryEntity>>
}

class FetchChildCategoryListUseCaseImpl @Inject constructor(
    private val repository: ChildCategoryRepository
): FetchChildCategoryListUseCase {
    override suspend fun invoke(parentCategorySeq: Int): Flow<List<ChildCategoryEntity>> {
        return withContext(Dispatchers.IO) {
            repository.fetchChildCategoryList(parentCategorySeq)
        }
    }
}
