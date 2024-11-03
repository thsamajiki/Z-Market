package com.hero.z_market.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParentCategoryModel(
    val parentCategorySeq: Int,
    val parentCategoryName: String,
    val parentCategoryImgPath: String,
    val parentCategoryCode: String,
): Parcelable
