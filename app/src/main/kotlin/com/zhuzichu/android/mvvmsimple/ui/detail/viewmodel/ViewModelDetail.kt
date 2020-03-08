package com.zhuzichu.android.mvvmsimple.ui.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import com.zhuzichu.android.mvvm.base.BaseViewModel
import com.zhuzichu.android.mvvmsimple.ui.detail.arg.ArgText
import com.zhuzichu.android.shared.ext.createCommand
import javax.inject.Inject

class ViewModelDetail @Inject constructor() : BaseViewModel<ArgText>() {

    val content = MutableLiveData<String>()

    val onClickHomeEvent = createCommand {

    }

    override fun initArgs(arg: ArgText) {
        content.value = arg.content
    }

}