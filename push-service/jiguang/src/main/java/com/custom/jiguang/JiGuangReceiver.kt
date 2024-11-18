package com.custom.push.jiguang

import android.content.Context
import android.content.Intent
import cn.jpush.android.api.CmdMessage
import cn.jpush.android.api.CustomMessage
import cn.jpush.android.api.JPushInterface
import cn.jpush.android.api.NotificationMessage
import cn.jpush.android.service.JPushMessageReceiver
import com.custom.jiguang.JiGuangPushManager
import com.custom.logger.LoggerManager
import org.json.JSONObject

class JiGuangReceiver : JPushMessageReceiver() {


    val TAG: String = "JPushMessageReceiver"

    override fun onMessage(context: Context, customMessage: CustomMessage) {
        LoggerManager.d(TAG, "[onMessage] $customMessage")
        val intent = Intent("com.jiguang.demo.message")
        intent.putExtra("msg", customMessage.message)
        context.sendBroadcast(intent)
    }

    override fun onNotifyMessageOpened(context: Context, message: NotificationMessage) {
        LoggerManager.d(TAG, "[onNotifyMessageOpened] $message")
        try {
            //打开自定义的Activity
            val fullClassName =
                JiGuangPushManager.getInstance().getIntentMap("key1")
            JiGuangPushManager.getInstance().startActivity(context, fullClassName, message)


        } catch (throwable: Throwable) {
        }
    }

    override fun onMultiActionClicked(context: Context?, intent: Intent) {
        LoggerManager.d(TAG, "[onMultiActionClicked] 用户点击了通知栏按钮")
        val nActionExtra = intent.extras!!.getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA)
        //开发者根据不同 Action 携带的 extra 字段来分配不同的动作。
        if (nActionExtra == null) {
            LoggerManager.d(TAG, "ACTION_NOTIFICATION_CLICK_ACTION nActionExtra is null")
            return
        }
        if (nActionExtra == "my_extra1") {
            LoggerManager.d(TAG, "[onMultiActionClicked] 用户点击通知栏按钮一")
        } else if (nActionExtra == "my_extra2") {
            LoggerManager.d(TAG, "[onMultiActionClicked] 用户点击通知栏按钮二")
        } else if (nActionExtra == "my_extra3") {
            LoggerManager.d(TAG, "[onMultiActionClicked] 用户点击通知栏按钮三")
        } else {
            LoggerManager.d(TAG, "[onMultiActionClicked] 用户点击通知栏按钮未定义")
        }
    }

    override fun onNotifyMessageArrived(context: Context?, message: NotificationMessage) {
        LoggerManager.d(TAG, "[onNotifyMessageArrived] $message")
    }

    override fun onNotifyMessageDismiss(context: Context?, message: NotificationMessage) {
        LoggerManager.d(TAG, "[onNotifyMessageDismiss] $message")
    }

    override fun onRegister(context: Context, registrationId: String) {
        LoggerManager.d(TAG, "[onRegister] $registrationId")
        val intent = Intent("com.jiguang.demo.message")
        intent.putExtra("rid", registrationId)
        context.sendBroadcast(intent)
    }

    override fun onConnected(context: Context?, isConnected: Boolean) {
        LoggerManager.d(TAG, "[onConnected] $isConnected")
    }

    override fun onCommandResult(context: Context?, cmdMessage: CmdMessage) {
        LoggerManager.d(TAG, "[onCommandResult] $cmdMessage")
    }


    override fun onNotificationSettingsCheck(context: Context?, isOn: Boolean, source: Int) {
        super.onNotificationSettingsCheck(context, isOn, source)
        LoggerManager.d(TAG, "[onNotificationSettingsCheck] isOn:$isOn,source:$source")
    }

}