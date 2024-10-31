package com.hero.z_market.di

import com.hero.z_market.api.ParentCategoryClassifiedService
import com.hero.z_market.api.SearchedGoodsService
import com.hero.z_market.api.SubCategoryClassifiedService
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
//            .cookieJar(JavaNetCookieJar(CookieManager()))
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
    fun provideParentCategoryClassifiedService(retrofit: Retrofit): ParentCategoryClassifiedService {
        return retrofit.create(ParentCategoryClassifiedService::class.java)
    }

    @Singleton
    @Provides
    fun provideSubCategoryClassifiedService(retrofit: Retrofit): SubCategoryClassifiedService {
        return retrofit.create(SubCategoryClassifiedService::class.java)
    }

    @Singleton
    @Provides
    fun provideSearchedGoodsService(retrofit: Retrofit): SearchedGoodsService {
        return retrofit.create(SearchedGoodsService::class.java)
    }
}