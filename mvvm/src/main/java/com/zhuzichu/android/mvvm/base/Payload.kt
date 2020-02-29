package com.zhuzichu.android.mvvm.base

import androidx.navigation.AnimBuilder

internal sealed class Payload {

    internal data class Start(
        val actionId: Int,
        val arg: BaseArg,
        val animBuilder: AnimBuilder?,
        val destinationId: Int?,
        val inclusive: Boolean?,
        val singleTop: Boolean?
    )

}