package com.hero.z_market.domain.usecase

import com.hero.z_market.data.response.PaginationItem
import com.hero.z_market.domain.repository.GoodsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface FetchPaginationInfoUseCase {
    suspend operator fun invoke(parentCategorySeq: Int,
                                childCategorySeq: Int,
                                page: Int,
                                size: Int,
                                query: String,): Flow<PaginationItem>
}

class FetchPaginationInfoUseCaseImpl @Inject constructor(
    private val goodsRepository: GoodsRepository
): FetchPaginationInfoUseCase {
    override suspend fun invoke(
        parentCategorySeq: Int,
        childCategorySeq: Int,
        page: Int,
        size: Int,
        query: String,
    ): Flow<PaginationItem> {
        return withContext(Dispatchers.IO) {
            goodsRepository.fetchPaginationInfo(
                parentCategorySeq,
                childCategorySeq,
                page,
                size,
                query
            )
        }
    }
}
