package com.example.core.application

import android.app.Application
import com.custom.push.PushServiceManager

open class AppCom : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化
        PushServiceManager.initJiGuang(applicationContext)
    }
}