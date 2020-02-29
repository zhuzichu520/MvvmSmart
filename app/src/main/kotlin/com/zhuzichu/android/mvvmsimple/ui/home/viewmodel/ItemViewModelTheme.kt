package com.zhuzichu.android.mvvmsimple.ui.home.viewmodel

import com.zhuzichu.android.mvvm.base.BaseItemViewModel
import com.zhuzichu.android.shared.extension.createCommand

data class ItemViewModelTheme(
    val viewModel: ViewModelHome,
    val titleId: Int,
    val mode: Int,
    val isSelected: Boolean
) : BaseItemViewModel(viewModel) {

    val onClickItemCommand = createCommand {
        viewModel.onThemeChangeEvent.value = mode
    }
}