package com.zhuzichu.android.mvvm.base

interface IBaseView<TArg : BaseArg> {

    fun initArgs(arg: TArg)

    fun initViewObservable()

    fun initVariable()

    fun initView()

    fun initData()

    fun initFirstData()

    fun initLazyData()

    fun initLazyView()

}