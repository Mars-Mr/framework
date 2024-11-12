package com.example.net.response

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type




open class NetworkResponseAdapterFactory : CallAdapter.Factory() {
    override fun get(
        type: Type,
        annotation: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (Call::class.java != getRawType(type)) {
            return null
        }
        check(type is ParameterizedType) {
            "returnn type must be parameterized as Call<NetworkResponse<<Foo>> or Call<Netw"
        }
        val responseType = getParameterUpperBound(0, type)
        if (getRawType(responseType) != NetWorkResponse::class.java) {
            return null
        }
        check(responseType is ParameterizedType){
            "Response must be parameterized as Netw"
        }
        return object :CallAdapter<Any, Call<*>?>{
            override fun responseType(): Type {
                return responseType
            }

            override fun adapt(call: Call<Any>): Call<*> {
                return NetworkResponseCall(call)
            }

        }
    }
}