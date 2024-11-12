package com.example.net.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import kotlin.math.log

class CommonRequestIntercept : Interceptor {

    private val TAG = CommonResponseIntercept::class.java.name

    override fun intercept(chain: Interceptor.Chain): Response {
        var currentTimeMillis = System.currentTimeMillis()
        var response = chain.proceed(chain.request())
        Log.e(TAG, "intercept: ${System.currentTimeMillis() - currentTimeMillis}")
        return response
    }
}