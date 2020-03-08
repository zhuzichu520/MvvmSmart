package com.zhuzichu.android.mvvmsimple.ui.demo.fresco.fragment

import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentFrescoBinding
import com.zhuzichu.android.mvvmsimple.ui.demo.fresco.viewmodel.ViewModelFresco

class FragmentFresco : BaseFragment<FragmentFrescoBinding, ViewModelFresco, DefaultArg>() {

    override fun setLayoutId(): Int = R.layout.fragment_fresco

    override fun bindVariableId(): Int = BR.viewModel

}