package com.hero.z_market.network

import com.hero.z_market.data.response.PageResponseAppGoodsInfoDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoodsService {
    @GET("app/disp-clas-infos/disp-clas/{dispClasSeq}/sub-disp-clas/{subDispClasSeq}/goods-infos")
    suspend fun fetchGoods(
        @Path("dispClasSeq") parentCategorySeq: Int,
        @Path("subDispClasSeq") childCategorySeq: Int,
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("searchValue") query: String
    ): PageResponseAppGoodsInfoDTO
}
