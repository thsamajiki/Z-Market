package com.hero.z_market.data.repository

import com.hero.z_market.data.remote.ChildCategoryDataSource
import com.hero.z_market.data.response.toEntity
import com.hero.z_market.domain.model.ChildCategoryModel
import com.hero.z_market.domain.repository.ChildCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ChildCategoryRepositoryImpl @Inject constructor(
    private val childCategoryDataSource: ChildCategoryDataSource
): ChildCategoryRepository {
    override suspend fun fetchChildCategoryList(parentCategorySeq: Int): Flow<List<ChildCategoryModel>> {
        return flow {
            val childCategoryList = childCategoryDataSource.fetchChildCategoryList(parentCategorySeq)
                .childCategoryInfoList
                .childCategoryInfoList
                .map { appSubDispClasInfoDTO ->
                    appSubDispClasInfoDTO.toEntity()
                }

            emit(childCategoryList)
        }.flowOn(Dispatchers.IO)
    }
}
