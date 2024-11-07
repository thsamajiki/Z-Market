package com.hero.z_market.domain.usecase

import com.hero.z_market.domain.model.ChildCategoryModel
import com.hero.z_market.domain.repository.ChildCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface FetchChildCategoryListUseCase {
    suspend fun invoke(parentCategorySeq: Int): Flow<List<ChildCategoryModel>>
}

class FetchChildCategoryListUseCaseImpl @Inject constructor(
    private val repository: ChildCategoryRepository
): FetchChildCategoryListUseCase {
    override suspend fun invoke(parentCategorySeq: Int): Flow<List<ChildCategoryModel>> {
        return withContext(Dispatchers.IO) {
            repository.fetchChildCategoryList(parentCategorySeq)
        }
    }
}
