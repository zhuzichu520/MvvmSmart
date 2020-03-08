package com.zhuzichu.android.mvvmsimple.ui.demo.main.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import com.zhuzichu.android.mvvm.base.BaseItemViewModel
import com.zhuzichu.android.mvvm.base.BaseViewModel
import com.zhuzichu.android.shared.ext.createCommand

class ItemViewModelDemo(
    viewModel: BaseViewModel<*>,
    type: Int,
    @StringRes stringId: Int,
    closure: Int.() -> Unit
) : BaseItemViewModel(viewModel) {

    val title = MutableLiveData(stringId)

    val onClickItem = createCommand {
        closure.invoke(type)
    }

}