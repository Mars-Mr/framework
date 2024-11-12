package com.custom.net

import com.custom.net.base.BaseNetworkApi
import okhttp3.Interceptor

class PaymentApi : BaseNetworkApi("") {
    override fun getInterceptor(): Interceptor {
        return Interceptor { chain ->
            val time = System.currentTimeMillis().toString()
            var newBuilder = chain.request().newBuilder()
            newBuilder.addHeader("heaer", "hello")
            chain.proceed(newBuilder.build())
        }
    }
}