package com.hero.z_market.di

import com.hero.z_market.data.remote.ChildCategoryDataSource
import com.hero.z_market.data.remote.ChildCategoryDataSourceImpl
import com.hero.z_market.data.remote.GoodsDataSource
import com.hero.z_market.data.remote.GoodsDataSourceImpl
import com.hero.z_market.data.remote.ParentCategoryDataSource
import com.hero.z_market.data.remote.ParentCategoryDataSourceImpl
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
    abstract fun bindParentCategoryDataSource(
        parentCategoryDataSourceImpl: ParentCategoryDataSourceImpl
    ): ParentCategoryDataSource

    @Singleton
    @Binds
    abstract fun bindChildCategoryDataSourceImpl(
        childCategoryDataSourceImpl: ChildCategoryDataSourceImpl
    ): ChildCategoryDataSource

    @Singleton
    @Binds
    abstract fun bindGoodsDataSource(
        goodsDataSourceImpl: GoodsDataSourceImpl
    ): GoodsDataSource
}
