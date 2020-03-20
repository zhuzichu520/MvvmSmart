package com.zhuzichu.android.mvvmsimple.ui.demo.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.zhuzichu.android.mvvm.base.BaseViewModel
import com.zhuzichu.android.mvvm.base.ArgDefault
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.shared.ext.map
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import javax.inject.Inject

class ViewModelDemo @Inject constructor() : BaseViewModel<ArgDefault>() {

    companion object {
        const val TYPE_NAVIGATION = 0
        const val TYPE_FRESCO = 1;
    }

    private val closure: Int.() -> Unit = {
        when (this) {
            TYPE_NAVIGATION -> {
                start(R.id.action_fragmentMain_to_fragmentNavigation)
            }
            TYPE_FRESCO -> {
                start(R.id.action_fragmentMain_to_fragmentFresco)
            }
            else -> {

            }
        }
    }

    val items = MutableLiveData<List<Any>>().apply {
        value = listOf(
            ItemViewModelDemo(
                this@ViewModelDemo,
                TYPE_NAVIGATION,
                R.string.demo_navigation,
                closure
            ),
            ItemViewModelDemo(
                this@ViewModelDemo,
                TYPE_FRESCO,
                R.string.demo_fresco,
                closure
            )
        )
    }

    val itemBinding = OnItemBindClass<Any>().apply {
        map<ItemViewModelDemo>(BR.item, R.layout.item_demo)
    }

}