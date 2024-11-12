package com.example.net

import android.app.Application

interface INetworkRequiredInfo {
    fun isDebug(): Boolean
    fun getAppVersionName(): String
    fun getAppVersionCode(): String
    fun getApplication(): Application
}