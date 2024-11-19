package com.hero.z_market.di

import com.hero.z_market.data.remote.ChildCategoryRemoteDataSource
import com.hero.z_market.data.remote.ChildCategoryRemoteDataSourceImpl
import com.hero.z_market.data.remote.GoodsRemoteDataSource
import com.hero.z_market.data.remote.GoodsRemoteDataSourceImpl
import com.hero.z_market.data.remote.ParentCategoryRemoteDataSource
import com.hero.z_market.data.remote.ParentCategoryRemoteDataSourceImpl
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
    abstract fun bindParentCategoryRemoteDataSource(
        parentCategoryRemoteDataSourceImpl: ParentCategoryRemoteDataSourceImpl
    ): ParentCategoryRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindChildCategoryRemoteDataSource(
        childCategoryRemoteDataSourceImpl: ChildCategoryRemoteDataSourceImpl
    ): ChildCategoryRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindGoodsRemoteDataSource(
        goodsRemoteDataSourceImpl: GoodsRemoteDataSourceImpl
    ): GoodsRemoteDataSource
}
