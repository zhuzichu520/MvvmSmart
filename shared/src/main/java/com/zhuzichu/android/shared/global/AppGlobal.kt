package com.zhuzichu.android.shared.global

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.tencent.mmkv.MMKV
import com.zhuzichu.android.shared.log.lumberjack.FileLoggingSetup
import com.zhuzichu.android.shared.log.lumberjack.FileLoggingTree
import com.zhuzichu.android.shared.log.lumberjack.L
import com.zhuzichu.android.shared.theme.ThemeManager
import timber.log.ConsoleTree

object AppGlobal {

    private lateinit var application: Application

    val context: Context by lazy {
        application.applicationContext
    }

    fun init(application: Application): AppGlobal {
        AppGlobal.application = application
        CacheGlobal.initDir()
        MMKV.initialize(CacheGlobal.getMmkvCacheDir())
        L.plant(ConsoleTree())
        L.plant(FileLoggingTree(FileLoggingSetup(context).withFolder(CacheGlobal.getLogCacheDir())))
        AppCompatDelegate.setDefaultNightMode(ThemeManager.getNightMode())
        return this
    }

}