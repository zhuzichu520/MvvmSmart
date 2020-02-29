package com.zhuzichu.android.mvvmsimple.di

import com.zhuzichu.android.mvvm.di.ActivityScoped
import com.zhuzichu.android.mvvmsimple.ActivityMain
import com.zhuzichu.android.mvvmsimple.ui.category.module.ModuleCategory
import com.zhuzichu.android.mvvmsimple.ui.demo.module.ModuleDemo
import com.zhuzichu.android.mvvmsimple.ui.detail.activity.ActivityDetail
import com.zhuzichu.android.mvvmsimple.ui.detail.module.ModuleDetail
import com.zhuzichu.android.mvvmsimple.ui.home.module.ModuleHome
import com.zhuzichu.android.mvvmsimple.ui.main.module.ModuleMain
import com.zhuzichu.android.mvvmsimple.ui.me.module.ModuleMe
import com.zhuzichu.android.mvvmsimple.ui.theme.module.ModuleTheme

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            //fragments
            ModuleMain::class,
            ModuleHome::class,
            ModuleCategory::class,
            ModuleMe::class,
            ModuleDemo::class,
            ModuleDetail::class,
            ModuleTheme::class
        ]
    )
    internal abstract fun mainActivity(): ActivityMain

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            ModuleDetail::class
        ]
    )
    internal abstract fun detailActivity(): ActivityDetail
}