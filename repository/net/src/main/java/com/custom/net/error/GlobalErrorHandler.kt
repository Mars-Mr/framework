package com.example.net.error

import android.util.Log
import com.example.net.response.NetworkResponseAdapterFactory

class GlobalErrorHandler : NetworkResponseAdapterFactory.ErrorHandler {

    val TAG = GlobalErrorHandler::class.java.name

    override fun onFailure(throwable: BusinessException) {
        when (throwable.code) {
            2034 -> {
                Log.e("TAG", "onFailure: ")
            }

            32123 -> {
                Log.e("TAG", "onFailure: ")
            }
        }
    }

}