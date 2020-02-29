package com.zhuzichu.android.shared.http.converter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class WanGsonConverterFactory(
    private val gson: Gson
) : Converter.Factory() {

    companion object {
        fun create(): WanGsonConverterFactory = WanGsonConverterFactory(Gson())
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, out Any?>? {
        return GsonResponseBodyConverter(gson, type)
    }


    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<out Any, RequestBody>? {
        return GsonRequestBodyConverter(gson, gson.getAdapter(TypeToken.get(type)))
    }

}