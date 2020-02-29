package com.zhuzichu.android.mvvmsimple.ui.detail.arg

import com.zhuzichu.android.mvvm.base.BaseArg
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ArgText(
    var content: String? = null
) : BaseArg()