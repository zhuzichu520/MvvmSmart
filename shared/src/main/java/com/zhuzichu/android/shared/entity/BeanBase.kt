package com.zhuzichu.android.shared.entity

import com.google.gson.annotations.SerializedName

data class BeanBase<T>(
    @SerializedName("data")
    var `data`: T? = null,
    @SerializedName("errorCode")
    var errorCode: Int? = null,
    @SerializedName("errorMsg")
    var errorMsg: String? = null
)