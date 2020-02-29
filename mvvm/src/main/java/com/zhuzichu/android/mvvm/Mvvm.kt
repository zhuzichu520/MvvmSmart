package com.zhuzichu.android.mvvm

import androidx.navigation.AnimBuilder
import androidx.navigation.NavOptions

object Mvvm {

    const val KEY_ARG = "arg";
    const val KEY_ARG_JSON = "argJson"

    internal var enterAnim = R.anim.h_enter
    internal var exitAnim = R.anim.h_exit
    internal var popEnterAnim = R.anim.h_pop_enter
    internal var popExitAnim = R.anim.h_pop_exit

    fun setAnimBuilder(animBuilder: AnimBuilder): Mvvm {
        enterAnim = animBuilder.enter
        exitAnim = animBuilder.exit
        popEnterAnim = animBuilder.popEnter
        popExitAnim = animBuilder.popExit
        return this
    }

    internal fun getDefaultNavOptions(
        destinationId: Int?,
        inclusive: Boolean?,
        singleTop: Boolean?,
        animBuilder: AnimBuilder?
    ): NavOptions {
        return NavOptions.Builder().apply {
            if (destinationId != null && inclusive != null) {
                setPopUpTo(destinationId, inclusive)
            }
            singleTop?.let {
                setLaunchSingleTop(singleTop)
            }
            setEnterAnim(animBuilder?.enter ?: enterAnim)
            setExitAnim(animBuilder?.exit ?: exitAnim)
            setPopEnterAnim(animBuilder?.popEnter ?: popEnterAnim)
            setPopExitAnim(animBuilder?.popExit ?: popExitAnim)
        }.build()
    }

}