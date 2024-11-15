package com.custom.net

import com.custom.net.base.BaseNetworkApi
import okhttp3.Interceptor

object BusinessApi : BaseNetworkApi("") {
    override fun getInterceptor(): Interceptor? {
        return null
    }

}