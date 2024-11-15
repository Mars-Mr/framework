package com.custom.repository.proxy

import android.app.Application
import com.custom.mmkv.IMMKVService
import com.custom.mmkv.MMKVService

class MMKVProxy : IMMKVService {
    override fun withMKKV(application: Application) {
        MMKVService.getInstance().withMKKV(application)
    }

    override fun putData(key: String, value: Any) {
        MMKVService.getInstance().putData(key, value)
    }

    override fun getInt(key: String, value: Int?): Int {
        return MMKVService.getInstance().getInt(key, value)
    }

    override fun getFloat(key: String, value: Float?): Float {
        return MMKVService.getInstance().getFloat(key, value)
    }

    override fun getLong(key: String, value: Long?): Long {
        return MMKVService.getInstance().getLong(key, value)
    }

    override fun getString(key: String, value: String?): String {
        return MMKVService.getInstance().getString(key, value)
    }

    override fun getBoolean(key: String, value: Boolean?): Boolean {
        return MMKVService.getInstance().getBoolean(key, value)
    }

    override fun getByteArray(key: String, value: ByteArray?): ByteArray {
        return MMKVService.getInstance().getByteArray(key, value)
    }

    override fun getSetString(key: String, value: Set<String>?): MutableSet<String> {
        return MMKVService.getInstance().getSetString(key, value)
    }


}