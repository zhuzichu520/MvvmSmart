package com.zhuzichu.android.mvvmsimple.ui.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.navigation.AnimBuilder
import com.zhuzichu.android.libs.tool.encodeBase64
import com.zhuzichu.android.libs.tool.object2Json
import com.zhuzichu.android.mvvm.Mvvm
import com.zhuzichu.android.mvvm.base.BaseViewModel
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvm.event.SingleLiveEvent
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.ui.detail.arg.ArgText
import com.zhuzichu.android.shared.extension.createCommand
import javax.inject.Inject

class ViewModelDemo @Inject constructor() : BaseViewModel<DefaultArg>() {

    val onClickDeepLinkEvent = SingleLiveEvent<Unit>()

    val onStartFragmentEvent = createCommand {
        start(R.id.action_fragmentMain_to_fragmentDetail, ArgText("Fragment 一页书：世事如棋，乾坤莫测，笑尽英雄啊！！"))
    }

    val onStartActivityEvent = createCommand {
        start(R.id.action_fragmentMain_to_activityDetail, ArgText("Activity 一页书：世事如棋，乾坤莫测，笑尽英雄啊！！"))
    }

    val onStartDialogFragmentEvent = createCommand {
        start(
            R.id.action_fragmentMain_to_dialogFragmentDetail,
            ArgText("DialogFragment 一页书:世事如棋，乾坤莫测，笑尽英雄啊！！")
        )
    }

    val onStartDialogBottomFragmentEvent = createCommand {
        //        start(
//            R.id.action_fragmentMain_to_dialogBottomFragmentDetail,
//            ArgText("DialogBottomFragment 一页书:世事如棋，乾坤莫测，笑尽英雄啊！！")
//        )
        start(R.id.action_fragmentMain_to_dialogFragmentChooseTheme)
    }

    val text = MutableLiveData<String>().apply {
        value = "点击Url跳转Activity：https://www.zhuzichu.com/content/".plus(
            encodeBase64(
                object2Json(ArgText("Url跳转 一页书:世事如棋，乾坤莫测，笑尽英雄啊！！"))
            )
        )
    }

    val onStartDeepLinkEvent = createCommand {
        onClickDeepLinkEvent.call()
    }

    val onAnimNoEvent = createCommand {
        Mvvm.setAnimBuilder(AnimBuilder().apply {
            enter = R.anim.no_anim
            exit = R.anim.no_anim
            popEnter = R.anim.no_anim
            popExit = R.anim.no_anim
        })
    }

    val onAnimHorizontalEvent = createCommand {
        Mvvm.setAnimBuilder(AnimBuilder().apply {
            enter = R.anim.h_enter
            exit = R.anim.h_exit
            popEnter = R.anim.h_pop_enter
            popExit = R.anim.h_pop_exit
        })
    }

    val onAnimVerticalEvent = createCommand {
        Mvvm.setAnimBuilder(AnimBuilder().apply {
            enter = R.anim.v_enter
            exit = R.anim.v_exit
            popEnter = R.anim.v_pop_enter
            popExit = R.anim.v_pop_exit
        })
    }


}