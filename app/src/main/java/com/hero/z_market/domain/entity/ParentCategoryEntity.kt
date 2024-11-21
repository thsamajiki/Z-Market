package com.hero.z_market.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParentCategoryEntity(
    val parentCategorySeq: Int,
    val parentCategoryName: String,
    val parentCategoryImgPath: String,
    val parentCategoryCode: String,
): Parcelable
