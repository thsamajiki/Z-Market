package com.hero.z_market.network

import com.hero.z_market.data.response.SingleResultAppDispClasInfoBySubDispClasInfoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ChildCategoryService {
    @GET("app/disp-clas-infos/disp-clas/{dispClasSeq}/sub-disp-clas-infos")
    suspend fun fetchChildCategoryList(
        @Path("dispClasSeq") parentCategorySeq: Int
    ): SingleResultAppDispClasInfoBySubDispClasInfoDTO
}
