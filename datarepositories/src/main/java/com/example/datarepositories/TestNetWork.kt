package com.example.datarepositories

import android.app.Application
import com.example.net.INetworkRequiredInfo

class TestNetWork(private val application: Application) : INetworkRequiredInfo {
    
    override fun isDebug(): Boolean {
        return true
    }

    override fun getAppVersionName(): String {
        return ""
    }

    override fun getAppVersionCode(): String {
        return ""
    }

    override fun getApplication(): Application {
        return application
    }
}