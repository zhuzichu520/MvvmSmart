package com.zhuzichu.android.mvvmsimple.base

import android.os.Bundle
import com.zhuzichu.android.mvvm.base.BaseActivity
import com.zhuzichu.android.shared.theme.ThemeManager

abstract class ActivityBase : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeManager.applyThemeOverlays(this)
        super.onCreate(savedInstanceState)
    }
}