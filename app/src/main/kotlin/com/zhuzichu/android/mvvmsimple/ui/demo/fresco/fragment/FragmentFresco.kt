package com.zhuzichu.android.mvvmsimple.ui.demo.fresco.fragment

import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.ArgDefault
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentFrescoBinding
import com.zhuzichu.android.mvvmsimple.ui.demo.fresco.viewmodel.ViewModelFresco

class FragmentFresco : BaseFragment<FragmentFrescoBinding, ViewModelFresco, ArgDefault>() {

    override fun setLayoutId(): Int = R.layout.fragment_fresco

    override fun bindVariableId(): Int = BR.viewModel

}