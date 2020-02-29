package com.zhuzichu.android.mvvmsimple.ui.home.fragment

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentHomeBinding
import com.zhuzichu.android.mvvmsimple.ui.home.viewmodel.ViewModelHome
import com.zhuzichu.android.shared.storage.ThemeStorage

class FragmentHome : BaseFragment<FragmentHomeBinding, ViewModelHome, DefaultArg>() {

    override fun bindVariableId(): Int = BR.viewModel

    override fun setLayoutId(): Int = R.layout.fragment_home

    override fun initData() {
        viewModel.updateTheme()
    }

    override fun initVariable() {
        viewModel.onThemeChangeEvent.observe(this, Observer {
            ThemeStorage.uiMode = it
            activityCtx.window.setWindowAnimations(R.style.WindowFade)
            AppCompatDelegate.setDefaultNightMode(ThemeStorage.uiMode)
            activityCtx.recreate()
        })
    }
}