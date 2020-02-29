package com.zhuzichu.android.mvvmsimple.ui.theme.viewmodel

import androidx.lifecycle.MutableLiveData
import com.zhuzichu.android.mvvm.base.BaseViewModel
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.shared.theme.ThemeManager
import javax.inject.Inject


class ViewModelTheme @Inject constructor() : BaseViewModel<DefaultArg>() {

    val checkedButton = MutableLiveData<Int>(ThemeManager.getCurrentThemeId())
}