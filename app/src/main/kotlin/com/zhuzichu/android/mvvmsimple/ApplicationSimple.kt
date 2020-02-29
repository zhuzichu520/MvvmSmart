package com.zhuzichu.android.mvvmsimple

import android.content.Context
import androidx.multidex.MultiDex
import androidx.navigation.AnimBuilder
import com.zhuzichu.android.mvvm.Mvvm
import com.zhuzichu.android.mvvmsimple.di.DaggerAppComponent
import com.zhuzichu.android.shared.crash.CrashConfig
import com.zhuzichu.android.shared.global.AppGlobal
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jonathanfinerty.once.Once

class ApplicationSimple : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        AppGlobal.init(this)
        Once.initialise(this)
        CrashConfig.Builder.create().apply()
        Mvvm.setAnimBuilder(
            AnimBuilder().apply {
                enter = R.anim.h_enter
                exit = R.anim.h_exit
                popEnter = R.anim.h_pop_enter
                popExit = R.anim.h_pop_exit
            }
        )
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}