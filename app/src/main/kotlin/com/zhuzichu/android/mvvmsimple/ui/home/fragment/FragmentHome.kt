package com.zhuzichu.android.mvvmsimple.ui.home.fragment

import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentHomeBinding
import com.zhuzichu.android.mvvmsimple.ui.home.viewmodel.ViewModelHome

class FragmentHome : BaseFragment<FragmentHomeBinding, ViewModelHome, DefaultArg>() {

    override fun bindVariableId(): Int = BR.viewModel

    override fun setLayoutId(): Int = R.layout.fragment_home

}