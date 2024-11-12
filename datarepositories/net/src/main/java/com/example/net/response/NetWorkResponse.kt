package com.example.net.response

sealed class NetWorkResponse<out T : Any> {
    data class Success<T : Any>(val body: T) : NetWorkResponse<T>()
    data class ApiError(val body: Any, val code: String) : NetWorkResponse<Nothing>()
    data class NetworkError(val message: String, val code: Int) : NetWorkResponse<Nothing>()
    data class UnknownError(val error: Throwable?) : NetWorkResponse<Nothing>()
}