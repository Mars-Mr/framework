package com.custom.repository.proxy

import com.custom.mmkv.IMMKVService
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class MMKVInvocationHandler(private val target: IMMKVService):InvocationHandler {
    override fun invoke(proxy: Any, method: Method, args: Array<out Any>): Any {
        println("Before invoking method: ${method.name}")
        val result = method.invoke(target, *(args ?: arrayOf()))
        println("After invoking method: ${method.name}")
        return result!!
    }
}