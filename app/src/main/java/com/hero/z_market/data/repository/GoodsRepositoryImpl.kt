package com.hero.z_market.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.hero.z_market.data.remote.GoodsPagingSource
import com.hero.z_market.data.remote.GoodsRemoteDataSource
import com.hero.z_market.data.response.PaginationItem
import com.hero.z_market.data.response.toEntity
import com.hero.z_market.domain.model.GoodsModel
import com.hero.z_market.domain.repository.GoodsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GoodsRepositoryImpl @Inject constructor(
    private val goodsRemoteDataSource: GoodsRemoteDataSource
): GoodsRepository {
    override suspend fun fetchGoods(
        parentCategorySeq: Int,
        childCategorySeq: Int,
        page: Int,
        size: Int,
        query: String,
    ): Flow<PagingData<GoodsModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20, // 한 번에 읽을 데이터 수
                enablePlaceholders = false
            ),
            initialKey = GoodsPagingSource.INITIAL_KEY,
            pagingSourceFactory = {
                GoodsPagingSource(goodsRemoteDataSource, parentCategorySeq, childCategorySeq, query)
            }
        )
            .flow
            .map { pagingData ->
                pagingData.map { appGoodsInfoDTO ->
                    appGoodsInfoDTO.toEntity()
                }
            }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchPaginationInfo(
        parentCategorySeq: Int,
        childCategorySeq: Int,
        page: Int,
        size: Int,
        query: String,
    ): Flow<PaginationItem> {
        return flow {
            val response = goodsRemoteDataSource.fetchGoods(parentCategorySeq, childCategorySeq, page, size, query).pagination.toEntity()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}
