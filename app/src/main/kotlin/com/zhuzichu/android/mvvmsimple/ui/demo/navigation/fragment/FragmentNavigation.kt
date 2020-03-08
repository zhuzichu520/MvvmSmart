package com.zhuzichu.android.mvvmsimple.ui.demo.navigation.fragment

import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.zhuzichu.android.mvvm.Mvvm
import com.zhuzichu.android.mvvm.base.BaseFragment
import com.zhuzichu.android.mvvm.base.DefaultArg
import com.zhuzichu.android.mvvmsimple.BR
import com.zhuzichu.android.mvvmsimple.R
import com.zhuzichu.android.mvvmsimple.databinding.FragmentNavigationBinding
import com.zhuzichu.android.mvvmsimple.ui.demo.navigation.viewmodel.ViewModelNavigation
import com.zhuzichu.android.mvvmsimple.ui.detail.arg.ArgText
import com.zhuzichu.android.widget.notify.NotifyManager
import javax.inject.Inject

class FragmentNavigation :
    BaseFragment<FragmentNavigationBinding, ViewModelNavigation, DefaultArg>() {

    @Inject
    lateinit var notifyManager: NotifyManager

    override fun bindVariableId(): Int = BR.viewModel

    override fun setLayoutId(): Int = R.layout.fragment_navigation

    override fun initViewObservable() {
        super.initViewObservable()
        viewModel.onClickDeepLinkEvent.observe(viewLifecycleOwner, Observer {
            val pendingIntent = navController.createDeepLink()
                .setGraph(R.navigation.navigation_main)
                .setDestination(R.id.fragmentDetail)
                .setArguments(bundleOf(Mvvm.KEY_ARG to ArgText("DeepLink之通知跳转 一页书：世事如棋，乾坤莫测，笑尽英雄啊！！")))
                .createPendingIntent()
            notifyManager.getCreator()
                .meta {
                    clickIntent = pendingIntent
                }
                .content {
                    title = "有一条新消息"
                    text = "Deeplink跳转到切换语言界面"
                }
                .show(1)
        })
    }

}