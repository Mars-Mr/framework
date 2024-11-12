package com.example.net.api

import com.example.net.beans.TestBean
import com.example.net.response.NetWorkResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("hello/adwa")
    suspend fun getAppDataFun(): NetWorkResponse<TestBean>

    @GET("hello/adwa")
    suspend fun hello(): NetWorkResponse<TestBean>
}