package com.hero.z_market.di

import com.hero.z_market.data.remote.ParentCategoryClassifiedDataSource
import com.hero.z_market.data.remote.ParentCategoryClassifiedDataSourceImpl
import com.hero.z_market.data.remote.SearchedGoodsDataSource
import com.hero.z_market.data.remote.SearchedGoodsDataSourceImpl
import com.hero.z_market.data.remote.SubCategoryClassifiedDataSource
import com.hero.z_market.data.remote.SubCategoryClassifiedDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindCategoryClassifiedDataSource(
        parentCategoryClassifiedDataSourceImpl: ParentCategoryClassifiedDataSourceImpl
    ): ParentCategoryClassifiedDataSource

    @Singleton
    @Binds
    abstract fun bindSubCategoryClassifiedDataSource(
        subCategoryClassifiedDataSourceImpl: SubCategoryClassifiedDataSourceImpl
    ): SubCategoryClassifiedDataSource

    @Singleton
    @Binds
    abstract fun bindSearchedGoodsDataSource(
        searchedGoodsDataSourceImpl: SearchedGoodsDataSourceImpl
    ): SearchedGoodsDataSource
}