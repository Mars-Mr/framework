package com.example.net

import com.example.net.api.ApiService
import com.example.net.beans.TestBean
import com.example.net.response.NetWorkResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkApi {
    companion object {
        val Baseurl = ""
        private var requiredInfo: INetworkRequiredInfo? = null

        fun init(requiredInfo: INetworkRequiredInfo) {
            this.requiredInfo = requiredInfo
        }

        suspend fun getDataMethod(): NetWorkResponse<TestBean> {
            val retrofit: Retrofit
            val retrofitBuild = Retrofit.Builder()
            retrofitBuild.baseUrl(Baseurl)
            retrofitBuild.client(getOkhttpClient())
            retrofitBuild.addConverterFactory(MoshiConverterFactory.create())
            retrofit = retrofitBuild.build()
            val timeStr = "xxxxx"
            return retrofit.create(ApiService::class.java).getAppDataFun()
        }

        private fun getOkhttpClient(): OkHttpClient {
            val okBuilder = OkHttpClient.Builder()
            if (this.requiredInfo != null && this.requiredInfo!!.isDebug()) {
                val httpLoggerInterceptor = HttpLoggingInterceptor()
                httpLoggerInterceptor.level = HttpLoggingInterceptor.Level.BODY
                okBuilder.addInterceptor(httpLoggerInterceptor)
            } else {
                //错误
            }
            return okBuilder.build()
        }
    }
}