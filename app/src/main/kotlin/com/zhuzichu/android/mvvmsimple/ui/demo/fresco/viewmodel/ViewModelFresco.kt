package com.zhuzichu.android.mvvmsimple.ui.demo.fresco.viewmodel

import androidx.lifecycle.MutableLiveData
import com.zhuzichu.android.mvvm.base.BaseViewModel
import com.zhuzichu.android.mvvm.base.DefaultArg
import javax.inject.Inject


class ViewModelFresco @Inject constructor() : BaseViewModel<DefaultArg>() {

    val url =
        MutableLiveData<String>("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1197500947,2658777821&fm=26&gp=0.jpg")
}