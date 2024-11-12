package com.example.net.interceptor

import com.example.net.INetworkRequiredInfo
import okhttp3.Interceptor
import okhttp3.Response

class CommonResponseIntercept(private val iNetworkRequiredInfo: INetworkRequiredInfo) :
    Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val newBuilder = chain.request().newBuilder()
        newBuilder.addHeader("xx", "xx")
        newBuilder.addHeader("appInfo1", iNetworkRequiredInfo.getAppVersionCode())
        newBuilder.addHeader("appInfo2", "source")
        newBuilder.addHeader("appInfo3", iNetworkRequiredInfo.getAppVersionName())
        return chain.proceed(newBuilder.build())
    }
}