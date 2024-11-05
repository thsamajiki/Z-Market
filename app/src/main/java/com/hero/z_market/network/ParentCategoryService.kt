package com.hero.z_market.network

import com.hero.z_market.data.response.ListResultAppDispClasInfoDTO
import retrofit2.http.GET

interface ParentCategoryService {
    @GET("app/disp-clas-infos/disp-clas-nm")
    suspend fun fetchParentCategoryList(): ListResultAppDispClasInfoDTO
}
