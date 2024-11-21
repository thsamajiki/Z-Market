package com.hero.z_market.data.repository

import com.hero.z_market.data.remote.ChildCategoryRemoteDataSource
import com.hero.z_market.data.response.toEntity
import com.hero.z_market.domain.entity.ChildCategoryEntity
import com.hero.z_market.domain.repository.ChildCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ChildCategoryRepositoryImpl @Inject constructor(
    private val childCategoryRemoteDataSource: ChildCategoryRemoteDataSource
): ChildCategoryRepository {
    override suspend fun fetchChildCategoryList(parentCategorySeq: Int): Flow<List<ChildCategoryEntity>> {
        return flow {
            val childCategoryList = childCategoryRemoteDataSource.fetchChildCategoryList(parentCategorySeq)
                .childCategoryInfoList
                .childCategoryInfoList
                .map { appSubDispClasInfoDTO ->
                    appSubDispClasInfoDTO.toEntity()
                }

            emit(childCategoryList)
        }.flowOn(Dispatchers.IO)
    }
}
