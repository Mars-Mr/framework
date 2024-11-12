package com.custom.net.base

import com.custom.net.response.MoshiResultTypeAdapterFactory
import com.example.net.INetworkRequiredInfo
import com.example.net.error.GlobalErrorHandler
import com.example.net.interceptor.CommonRequestIntercept
import com.example.net.interceptor.CommonResponseIntercept
import com.example.net.response.NetworkResponseAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class BaseNetworkApi(baseUrl: String) {
    protected lateinit var retrofit: Retrofit


    val Baseurl = ""
    private lateinit var requiredInfo: INetworkRequiredInfo
    private var globalErrorHandler: GlobalErrorHandler = GlobalErrorHandler()

    fun init(requiredInfo: INetworkRequiredInfo) {
        this.requiredInfo = requiredInfo
    }

    private val moshi =
        Moshi.Builder().add(MoshiResultTypeAdapterFactory()).addLast(KotlinJsonAdapterFactory())
            .build()

    private fun getOkhttpClient(): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
        okBuilder.addInterceptor(CommonRequestIntercept(requiredInfo))
        okBuilder.addInterceptor(CommonResponseIntercept(requiredInfo))
        getInterceptor()?.let { okBuilder.addInterceptor(it) }
        if (requiredInfo.isDebug()) {
            val httpLoggerInterceptor = HttpLoggingInterceptor()
            httpLoggerInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okBuilder.addInterceptor(httpLoggerInterceptor)
        } else {
            //错误
        }
        return okBuilder.build()
    }

    private fun log(msg: Any) = println("[${Thread.currentThread().name}]    ${msg}")


    protected abstract fun getInterceptor(): Interceptor?
    protected open fun getEnvelopeHandler(): Any? {
        return null
    }

    open fun <T> getService(service: Class<T>?): T {
        return retrofit.create(service)
    }

    init {
        val retrofitBuild = Retrofit.Builder()
        retrofitBuild.baseUrl(Baseurl)
        retrofitBuild.client(getOkhttpClient())
        retrofitBuild.addConverterFactory(MoshiConverterFactory.create(moshi))
        retrofitBuild.addCallAdapterFactory(NetworkResponseAdapterFactory(globalErrorHandler))
        retrofit = retrofitBuild.build()
    }

}