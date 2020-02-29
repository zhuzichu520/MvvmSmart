package com.zhuzichu.android.shared.http.converter

import com.google.gson.Gson
import com.zhuzichu.android.shared.entity.BeanBase
import com.zhuzichu.android.shared.http.exception.ExceptionManager
import okhttp3.ResponseBody
import retrofit2.Converter
import java.lang.reflect.Type

class GsonResponseBodyConverter<T>(
    private val gson: Gson,
    private val type: Type
) : Converter<ResponseBody, T> {

    override fun convert(value: ResponseBody): T {
        return value.use {
            val json = value.string()
            ExceptionManager.verify(gson.fromJson(json, BeanBase::class.java))
            gson.fromJson(json, type)
        }
    }
}