package com.zhuzichu.android.mvvmsimple.ui.theme.viewmodel

import androidx.lifecycle.MutableLiveData
import com.zhuzichu.android.mvvm.base.BaseViewModel
import com.zhuzichu.android.mvvm.base.ArgDefault
import com.zhuzichu.android.shared.theme.ThemeManager
import javax.inject.Inject


class ViewModelTheme @Inject constructor() : BaseViewModel<ArgDefault>() {

    val checkedButton = MutableLiveData<Int>(ThemeManager.getCurrentThemeId())
}