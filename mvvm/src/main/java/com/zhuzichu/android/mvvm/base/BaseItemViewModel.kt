package com.zhuzichu.android.mvvm.base

import androidx.lifecycle.ViewModel
import androidx.navigation.AnimBuilder


open class BaseItemViewModel(
    private val viewModel: BaseViewModel<*>
) : ViewModel(), IBaseCommon {

    override fun back() {
        viewModel.back()
    }

    override fun showLoading() {
        viewModel.showLoading()
    }

    override fun hideLoading() {
        viewModel.hideLoading()
    }

    override fun start(
        actionId: Int,
        arg: BaseArg?,
        animBuilder: AnimBuilder?,
        destinationId: Int?,
        inclusive: Boolean?,
        singleTop: Boolean?
    ) {
        viewModel.start(actionId, arg, animBuilder, destinationId, inclusive, singleTop)
    }

}