package com.zhuzichu.android.mvvmsimple.ui.me.fragment

import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentMeBinding
import com.zhuzichu.android.mvvmsimple.ui.me.viewmodel.ViewModelMe

class FragmentMe : BaseFragment<FragmentMeBinding, ViewModelMe, DefaultArg>() {

    override fun bindVariableId(): Int = BR.viewModel

    override fun setLayoutId(): Int = R.layout.fragment_me
}