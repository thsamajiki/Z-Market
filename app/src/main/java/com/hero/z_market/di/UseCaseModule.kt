package com.hero.z_market.di

import com.hero.z_market.domain.repository.ChildCategoryRepository
import com.hero.z_market.domain.repository.GoodsRepository
import com.hero.z_market.domain.repository.ParentCategoryRepository
import com.hero.z_market.domain.usecase.FetchChildCategoryListUseCase
import com.hero.z_market.domain.usecase.FetchChildCategoryListUseCaseImpl
import com.hero.z_market.domain.usecase.FetchGoodsUseCase
import com.hero.z_market.domain.usecase.FetchGoodsUseCaseImpl
import com.hero.z_market.domain.usecase.FetchPaginationInfoUseCase
import com.hero.z_market.domain.usecase.FetchPaginationInfoUseCaseImpl
import com.hero.z_market.domain.usecase.FetchParentCategoryListUseCase
import com.hero.z_market.domain.usecase.FetchParentCategoryListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideFetchParentCategoryListUseCase(
        parentCategoryRepository: ParentCategoryRepository
    ): FetchParentCategoryListUseCase = FetchParentCategoryListUseCaseImpl(parentCategoryRepository)

    @Provides
    @Singleton
    fun provideFetchGetChildCategoryListUseCase(
        childCategoryRepository: ChildCategoryRepository
    ): FetchChildCategoryListUseCase = FetchChildCategoryListUseCaseImpl(childCategoryRepository)

    @Provides
    @Singleton
    fun provideFetchGoodsUseCase(
        goodsRepository: GoodsRepository
    ): FetchGoodsUseCase = FetchGoodsUseCaseImpl(goodsRepository)

    @Provides
    @Singleton
    fun provideFetchPaginationInfoUseCase(
        goodsRepository: GoodsRepository
    ): FetchPaginationInfoUseCase = FetchPaginationInfoUseCaseImpl(goodsRepository)
}
