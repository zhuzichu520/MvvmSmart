package com.zhuzichu.android.shared.storage

import androidx.appcompat.app.AppCompatDelegate
import com.tencent.mmkv.MMKV

object ThemeStorage {
    private const val PREFS_NAME = "mmkv_theme"

    private val prefs: Lazy<MMKV> = lazy {
        MMKV.mmkvWithID(PREFS_NAME)
    }

    var uiMode by IntPreference(prefs, defaultValue = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
}