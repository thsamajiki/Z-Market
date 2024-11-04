package com.hero.z_market.di

import com.hero.z_market.domain.repository.ChildCategoryRepository
import com.hero.z_market.domain.repository.GoodsRepository
import com.hero.z_market.domain.repository.ParentCategoryRepository
import com.hero.z_market.domain.usecase.GetChildCategoryListUseCase
import com.hero.z_market.domain.usecase.GetChildCategoryListUseCaseImpl
import com.hero.z_market.domain.usecase.GetGoodsUseCase
import com.hero.z_market.domain.usecase.GetGoodsUseCaseImpl
import com.hero.z_market.domain.usecase.GetPaginationInfoUseCase
import com.hero.z_market.domain.usecase.GetPaginationInfoUseCaseImpl
import com.hero.z_market.domain.usecase.GetParentCategoryListUseCase
import com.hero.z_market.domain.usecase.GetParentCategoryListUseCaseImpl
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
    fun provideParentCategoryUseCase(
        parentCategoryRepository: ParentCategoryRepository
    ): GetParentCategoryListUseCase = GetParentCategoryListUseCaseImpl(parentCategoryRepository)

    @Provides
    @Singleton
    fun provideChildCategoryUseCase(
        childCategoryRepository: ChildCategoryRepository
    ): GetChildCategoryListUseCase = GetChildCategoryListUseCaseImpl(childCategoryRepository)

    @Provides
    @Singleton
    fun provideGoodsUseCase(
        goodsRepository: GoodsRepository
    ): GetGoodsUseCase = GetGoodsUseCaseImpl(goodsRepository)

    @Provides
    @Singleton
    fun providePaginationInfoUseCase(
        goodsRepository: GoodsRepository
    ): GetPaginationInfoUseCase = GetPaginationInfoUseCaseImpl(goodsRepository)
}
