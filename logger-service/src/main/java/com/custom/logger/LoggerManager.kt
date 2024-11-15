package com.custom.logger

import android.util.Log

object LoggerManager {
    private const val TAG = "com_qzn_mjzgz"
    private const val TAG_NET = "com_qzn_mjzgz_net"

    var sIsLogEnable = false

    fun enableLog() {
        sIsLogEnable = true
    }

    fun disableLog() {
        sIsLogEnable = false
    }

    fun showHttpHeaderLog(message: String?) {
        if (BuildConfig.isLogger) Log.d(TAG_NET, message.toString())
    }

    fun showHttpApiLog(message: String?) {
        if (BuildConfig.isLogger) Log.w(TAG_NET, message.toString())
    }

    fun showHttpLog(message: String?) {
        if (BuildConfig.isLogger) Log.i(TAG_NET, message.toString())
    }

    fun d(msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.d(TAG, "$fileInfo: $msg")
        }
    }

    fun d(tag: String?, msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.d(tag, "$fileInfo: $msg")
        }
    }

    fun i(msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.i(TAG, "$fileInfo: $msg")
        }
    }

    fun i(tag: String?, msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.i(tag, "$fileInfo: $msg")
        }
    }

    fun e(msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.e(TAG, "$fileInfo: $msg")
        }
    }

    fun e(tag: String?, msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.e(tag, "$fileInfo: $msg")
        }
    }

    fun w(msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.w(TAG, "$fileInfo: $msg")
        }
    }

    fun w(tag: String?, msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.w(tag, "$fileInfo: $msg")
        }
    }

    fun v(msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.v(TAG, "$fileInfo: $msg")
        }
    }

    fun v(tag: String?, msg: String) {
        if (sIsLogEnable) {
            val stackTrace = Thread.currentThread().stackTrace[3]
            val fileInfo =
                stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
            Log.v(tag, "$fileInfo: $msg")
        }
    }

    fun getStackTraceMsg(): String {
        val stackTrace =
            Thread.currentThread().stackTrace[3]
        return stackTrace.fileName + "(" + stackTrace.lineNumber + ") " + stackTrace.methodName
    }
}