package com.zhuzichu.android.mvvmsimple.ui.demo.main.fragment

import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentDemoBinding
import com.zhuzichu.android.mvvmsimple.ui.demo.main.viewmodel.ViewModelDemo

class FragmentDemo : BaseFragment<FragmentDemoBinding, ViewModelDemo, DefaultArg>() {

    override fun bindVariableId(): Int = BR.viewModel

    override fun setLayoutId(): Int = R.layout.fragment_demo

}