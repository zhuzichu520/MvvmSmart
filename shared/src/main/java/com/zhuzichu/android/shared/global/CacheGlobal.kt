package com.zhuzichu.android.shared.global

import com.zhuzichu.android.libs.tool.isExternalStorageWriteable
import com.zhuzichu.android.shared.global.AppGlobal.context
import java.io.File

object CacheGlobal {

    private const val CACHE_GLIDE_DIR = "/cache_glide"

    private const val CACHE_MMKV_DIR = "/cache_mmkv"

    private const val CACHE_LOG_DIR = "/cache_log"

    fun initDir() {
        getGlideCacheDir()
    }

    fun getLogCacheDir(): String {
        return getDiskCacheDir(CACHE_LOG_DIR).absolutePath
    }

    fun getMmkvCacheDir(): String {
        return getDiskCacheDir(CACHE_MMKV_DIR).absolutePath
    }

    fun getGlideCacheDir(): String {
        return getDiskCacheDir(CACHE_GLIDE_DIR).absolutePath
    }

    private fun getDiskCacheDir(last: String): File {
        val path: String = if (isExternalStorageWriteable()) {
            context.externalCacheDir.toString() + last
        } else {
            context.cacheDir.toString() + last
        }
        val file = File(path)
        if (!file.exists()) {
            file.mkdirs()
        }
        return file.absoluteFile
    }

}