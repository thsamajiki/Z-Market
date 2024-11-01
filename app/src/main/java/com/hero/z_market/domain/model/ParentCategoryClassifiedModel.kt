package com.hero.z_market.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParentCategoryClassifiedModel(
    val dispClasSeq: Int,
    val dispClasNm: String,
    val dispClasImgPath: String,
    val dispClasCd: String
): Parcelable