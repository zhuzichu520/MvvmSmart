package com.zhuzichu.android.mvvmsimple.ui.category.fragment

import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentCategoryBinding
import com.zhuzichu.android.mvvmsimple.ui.category.viewmodel.ViewModelCategory

class FragmentCategory :
    BaseFragment<FragmentCategoryBinding, ViewModelCategory, DefaultArg>() {

    override fun bindVariableId(): Int = BR.viewModel

    override fun setLayoutId(): Int = R.layout.fragment_category

}