package com.zhuzichu.android.mvvmsimple.ui.theme.fragment

import androidx.lifecycle.Observer
import com.zhuzichu.android.mvvm.base.BaseDialogBottomFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.DialogFragmentChooseThemeBinding
import com.zhuzichu.android.mvvmsimple.ui.theme.viewmodel.ViewModelTheme
import com.zhuzichu.android.shared.theme.ThemeManager


class DialogFragmentChooseTheme :
    BaseDialogBottomFragment<DialogFragmentChooseThemeBinding, ViewModelTheme, DefaultArg>() {

    override fun bindVariableId(): Int = BR.viewModel

    override fun setLayoutId(): Int = R.layout.dialog_fragment_choose_theme

    override fun initListener() {
        viewModel.checkedButton.observe(viewLifecycleOwner, Observer {
            ThemeManager.saveAndApplyTheme(it)
        })
    }
}