package com.example.net

import com.example.net.error.BusinessException

interface NetworkResponseAdapterFactory {
    fun onFailure(throwable: BusinessException)
}