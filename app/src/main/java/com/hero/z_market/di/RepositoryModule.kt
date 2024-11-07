package com.hero.z_market.di

import com.hero.z_market.data.repository.ChildCategoryRepositoryImpl
import com.hero.z_market.data.repository.GoodsRepositoryImpl
import com.hero.z_market.data.repository.ParentCategoryRepositoryImpl
import com.hero.z_market.domain.repository.ChildCategoryRepository
import com.hero.z_market.domain.repository.GoodsRepository
import com.hero.z_market.domain.repository.ParentCategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindParentCategoryRepository(
        parentCategoryRepositoryImpl: ParentCategoryRepositoryImpl,
    ): ParentCategoryRepository

    @Singleton
    @Binds
    abstract fun bindChildCategoryRepository(
        childCategoryRepositoryImpl: ChildCategoryRepositoryImpl,
    ): ChildCategoryRepository

    @Singleton
    @Binds
    abstract fun bindGoodsRepository(
        goodsRepositoryImpl: GoodsRepositoryImpl,
    ): GoodsRepository
}
