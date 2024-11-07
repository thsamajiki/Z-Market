package com.hero.z_market.domain.usecase

import androidx.paging.PagingData
import com.hero.z_market.domain.model.GoodsModel
import com.hero.z_market.domain.repository.GoodsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface FetchGoodsUseCase {
    suspend fun invoke(
        parentCategorySeq: Int,
        childCategorySeq: Int,
        page: Int,
        size: Int,
        searchValue: String,
    ): Flow<PagingData<GoodsModel>>
}

class FetchGoodsUseCaseImpl @Inject constructor(
    private val repository: GoodsRepository
): FetchGoodsUseCase {
    override suspend fun invoke(
        parentCategorySeq: Int,
        childCategorySeq: Int,
        page: Int,
        size: Int,
        query: String,
    ): Flow<PagingData<GoodsModel>> {
        return withContext(Dispatchers.IO) {
            repository.fetchGoods(parentCategorySeq, childCategorySeq, page, size, query)
        }
    }
}
