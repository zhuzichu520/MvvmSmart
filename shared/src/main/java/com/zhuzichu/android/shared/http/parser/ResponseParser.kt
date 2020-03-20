package com.zhuzichu.android.shared.http.parser

import com.zhuzichu.android.shared.http.entity.Response
import com.zhuzichu.android.shared.http.exception.ExceptionManager
import com.zhuzichu.android.shared.http.exception.ResponseThrowable
import rxhttp.wrapper.annotation.Parser
import rxhttp.wrapper.entity.ParameterizedTypeImpl
import rxhttp.wrapper.parse.AbstractParser
import java.lang.reflect.Type


@Parser(name = "Response")
class ResponseParser<T>(type: Type?) : AbstractParser<T>(type) {
    override fun onParse(response: okhttp3.Response): T? {
        val type: Type = ParameterizedTypeImpl.get(Response::class.java, mType) //获取泛型类型
        val data: Response<T> = convert(response, type)
        val t: T? = data.data
        if (data.errorCode != 0) {
            throw ResponseThrowable(
                data.errorCode ?: ExceptionManager.UNKNOWN,
                data.errorMsg ?: "未知错误"
            )
        }
        return t
    }
}