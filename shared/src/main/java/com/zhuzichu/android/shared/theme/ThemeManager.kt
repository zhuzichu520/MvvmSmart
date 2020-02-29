package com.zhuzichu.android.shared.theme

import android.app.Activity
import android.util.SparseIntArray
import androidx.annotation.*
import androidx.appcompat.app.AppCompatDelegate
import com.zhuzichu.android.shared.R
import com.zhuzichu.android.shared.storage.ThemeStorage

object ThemeManager {

    private val themeOverlays = SparseIntArray()
    private val THEME_NIGHT_MODE_MAP = SparseIntArray()

    init {
        THEME_NIGHT_MODE_MAP.append(
            R.id.theme_light,
            AppCompatDelegate.MODE_NIGHT_NO
        )
        THEME_NIGHT_MODE_MAP.append(
            R.id.theme_dark,
            AppCompatDelegate.MODE_NIGHT_YES
        )
        THEME_NIGHT_MODE_MAP.append(
            R.id.theme_default,
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        )

    }

    @IdRes
    fun getCurrentThemeId(): Int {
        return convertToThemeId(getNightMode())
    }

    @IdRes
    private fun convertToThemeId(nightMode: Int): Int {
        return THEME_NIGHT_MODE_MAP.keyAt(THEME_NIGHT_MODE_MAP.indexOfValue(nightMode))
    }

    fun getNightMode(): Int {
        return ThemeStorage.uiMode
    }

    fun saveAndApplyTheme(@IdRes id: Int) {
        val nightMode: Int = convertToNightMode(id)
        saveNightMode(nightMode)
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }

    private fun convertToNightMode(@IdRes id: Int): Int {
        return THEME_NIGHT_MODE_MAP.get(id, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }


    private fun saveNightMode(nightMode: Int) {
        ThemeStorage.uiMode = nightMode
    }

    fun setThemeOverlay(@IdRes id: Int, @StyleRes themeOverlay: Int) {
        themeOverlays.put(id, themeOverlay)
    }

    fun getThemeOverlay(@IdRes id: Int): Int {
        return themeOverlays.get(id)
    }

    fun applyThemeOverlays(activity: Activity) {
        for (i in 0 until themeOverlays.size()) {
            activity.setTheme(
                themeOverlays.valueAt(i)
            )
        }
    }

    @StyleableRes
    private val PRIMARY_THEME_OVERLAY_ATTRS = intArrayOf(
        R.attr.colorPrimary, R.attr.colorPrimaryDark
    )

    @StyleableRes
    private val SECONDARY_THEME_OVERLAY_ATTRS = intArrayOf(R.attr.colorSecondary)

    @StyleableRes
    fun getPrimaryThemeOverlayAttrs(): IntArray? {
        return PRIMARY_THEME_OVERLAY_ATTRS
    }

    @StyleableRes
    fun getSecondaryThemeOverlayAttrs(): IntArray? {
        return SECONDARY_THEME_OVERLAY_ATTRS
    }

    @AttrRes
    fun getPrimaryColor(): Int {
        return R.attr.colorPrimary
    }

    @ArrayRes
    fun getPrimaryColors(): Int {
        return R.array.mtrl_primary_palettes
    }

    @ArrayRes
    fun getSecondaryColors(): Int {
        return R.array.mtrl_secondary_palettes
    }

    @ArrayRes
    fun getPrimaryColorsContentDescription(): Int {
        return R.array.mtrl_palettes_content_description
    }

    @ArrayRes
    fun getSecondaryColorsContentDescription(): Int {
        return R.array.mtrl_palettes_content_description
    }

    fun getShapes(): Int {
        return R.array.mtrl_shape_overlays
    }

    fun getShapesContentDescription(): Int {
        return R.array.mtrl_shapes_content_description
    }

    fun getShapeSizes(): Int {
        return R.array.mtrl_shape_size_overlays
    }

    fun getShapeSizesContentDescription(): Int {
        return R.array.mtrl_shape_size_content_description
    }


}