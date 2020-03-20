package com.zhuzichu.android.mvvmsimple.ui.home.fragment

import com.uber.autodispose.autoDispose
import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.ArgDefault
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentHomeBinding
import com.zhuzichu.android.mvvmsimple.ui.home.viewmodel.ViewModelHome
import com.zhuzichu.android.shared.ext.bindToSchedulers
import com.zhuzichu.android.shared.ext.toast
import rxhttp.wrapper.param.RxHttp

class FragmentHome : BaseFragment<FragmentHomeBinding, ViewModelHome, ArgDefault>() {

    override fun bindVariableId(): Int = BR.viewModel

    override fun setLayoutId(): Int = R.layout.fragment_home

    override fun initLazyData() {
        super.initLazyData()
        RxHttp.get("/article/list/1/json")
            .asString()
            .bindToSchedulers()
            .autoDispose(viewModel)
            .subscribe {
                it.toast()
            }
    }

}