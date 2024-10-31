package com.hero.z_market.di

import com.hero.z_market.domain.repository.ParentCategoryClassifiedRepository
import com.hero.z_market.domain.repository.ParentCategoryClassifiedRepositoryImpl
import com.hero.z_market.domain.repository.SearchedGoodsRepository
import com.hero.z_market.domain.repository.SearchedGoodsRepositoryImpl
import com.hero.z_market.domain.repository.SubCategoryClassifiedRepository
import com.hero.z_market.domain.repository.SubCategoryClassifiedRepositoryImpl
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
    abstract fun bindCategoryClassifiedRepository(
        parentCategoryClassifiedRepositoryImpl: ParentCategoryClassifiedRepositoryImpl
    ): ParentCategoryClassifiedRepository

    @Singleton
    @Binds
    abstract fun bindSubCategoryClassifiedRepository(
        subCategoryClassifiedRepositoryImpl: SubCategoryClassifiedRepositoryImpl
    ): SubCategoryClassifiedRepository

    @Singleton
    @Binds
    abstract fun bindCategoryItemListRepository(
        searchedGoodsRepositoryImpl: SearchedGoodsRepositoryImpl
    ): SearchedGoodsRepository
}