package com.example.net.response

import com.squareup.moshi.Moshi
import okhttp3.Request
import okio.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkResponseCall<S : Any>(private val call: Call<S>) : Call<NetWorkResponse<S>> {

    override fun enqueue(callback: Callback<NetWorkResponse<S>>) {
        return call.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()
                if (response.isSuccessful) {
                    //200x
                    if (body != null) {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetWorkResponse.Success(body))
                        )
                    } else {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetWorkResponse.UnknownError(null))
                        )
                    }
                } else {
                    if (error != null && error.contentLength() > 0) {
                        //500x
                        val errorResponse = ""
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetWorkResponse.ApiError("", ""))
                        )

                    } else {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(
                                NetWorkResponse.NetworkError(
                                    error?.string() ?: "meesage is empty", code
                                )
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<S>, throwable: Throwable) {
                val netWorkResponse = when (throwable) {
                    is IOException -> NetWorkResponse.NetworkError(
                        throwable.message.toString(),
                        400
                    )

                    else -> NetWorkResponse.UnknownError(throwable)
                }
                callback.onResponse(this@NetworkResponseCall, Response.success((netWorkResponse)))
            }
        })
    }

    override fun clone() = NetworkResponseCall(call.clone())

    override fun execute(): Response<NetWorkResponse<S>> {
      throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun isExecuted() = call.isExecuted

    override fun cancel()= call.cancel()

    override fun isCanceled() = call.isCanceled

    override fun request(): Request {
        TODO("Not yet implemented")
    }

    override fun timeout(): Timeout {
        TODO("Not yet implemented")
    }

}