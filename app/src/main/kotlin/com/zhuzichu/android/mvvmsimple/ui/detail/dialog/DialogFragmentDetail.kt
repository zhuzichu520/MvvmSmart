package com.zhuzichu.android.mvvmsimple.ui.detail.dialog

import com.zhuzichu.android.mvvm.base.BaseDialogFragment
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentDetailBinding
import com.zhuzichu.android.mvvmsimple.ui.detail.arg.ArgText
import com.zhuzichu.android.mvvmsimple.ui.detail.viewmodel.ViewModelDetail

class DialogFragmentDetail : BaseDialogFragment<FragmentDetailBinding, ViewModelDetail, ArgText>() {

    override fun setLayoutId(): Int = R.layout.fragment_detail

    override fun bindVariableId(): Int = BR.viewModel

}