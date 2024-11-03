package com.hero.z_market.di

import com.hero.z_market.api.ChildCategoryService
import com.hero.z_market.api.GoodsService
import com.hero.z_market.api.ParentCategoryService
import com.hero.z_market.constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideParentCategoryService(retrofit: Retrofit): ParentCategoryService {
        return retrofit.create(ParentCategoryService::class.java)
    }

    @Singleton
    @Provides
    fun provideChildCategoryService(retrofit: Retrofit): ChildCategoryService {
        return retrofit.create(ChildCategoryService::class.java)
    }

    @Singleton
    @Provides
    fun provideGoodsService(retrofit: Retrofit): GoodsService {
        return retrofit.create(GoodsService::class.java)
    }
}
