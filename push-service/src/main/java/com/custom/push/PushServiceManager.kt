package com.custom.push

import android.content.Context
import com.custom.jiguang.JiGuangPushManager

object PushServiceManager {
    fun initJiGuang(c: Context) {
        JiGuangPushManager.getInstance().initJiGuang(c)
    }

    fun getJiGuangId() {
        JiGuangPushManager.getInstance().getRegisterID()
    }
}