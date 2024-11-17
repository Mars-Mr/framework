package com.custom.jiguang

import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.jiguang.api.utils.JCollectionAuth
import cn.jpush.android.api.JPushInterface
import cn.jpush.android.api.NotificationMessage
import cn.jpush.android.data.JPushConfig


class JiGuangPushManager private constructor() {

    private val intentMap: MutableMap<String, String> = mutableMapOf()

    companion object {
        @Volatile
        private var instance: JiGuangPushManager? = null

        fun getInstance(): JiGuangPushManager {
            if (instance == null) {
                synchronized(JiGuangPushManager::class.java) {
                    if (instance == null) {
                        instance = JiGuangPushManager()
                    }
                }
            }
            return instance!!
        }
    }

    fun initJiGuang(applicationContext: Context) {
        // 设置调试模式
        JPushInterface.setDebugMode(true);
        //init 初始化 SDK 与开启推送服务 API
        JPushInterface.init(applicationContext)
        JCollectionAuth.setAuth(applicationContext, true);
    }

    /**
     * 注册需要跳转的页面
     */
    fun registerActivity(key: String, fullClassName: String) {
        if (!intentMap.containsKey(key))
            intentMap[key] = fullClassName
    }

    /**
     * 启动跳转的页面
     */
    fun startActivity(context: Context, fullClassName: String, message: NotificationMessage) {
        //打开自定义的Activity
        val i = Intent()
        //隐式跳转
        i.setClassName(context, fullClassName)
        //Bundle
        val bundle = Bundle()
        //传参
        bundle.putString(JPushInterface.EXTRA_NOTIFICATION_TITLE, message.notificationTitle)
        bundle.putString(JPushInterface.EXTRA_ALERT, message.notificationContent)
        i.putExtras(bundle)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(i)
    }

}