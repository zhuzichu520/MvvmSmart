package com.zhuzichu.android.shared.entity
import com.google.gson.annotations.SerializedName


data class BeanPage<T>(
    @SerializedName("curPage")
    var curPage: Int? = null,
    @SerializedName("datas")
    var datas: List<T>? = null,
    @SerializedName("offset")
    var offset: Int? = null,
    @SerializedName("over")
    var over: Boolean? = null,
    @SerializedName("pageCount")
    var pageCount: Int? = null,
    @SerializedName("size")
    var size: Int? = null,
    @SerializedName("total")
    var total: Int? = null
)