package com.custom.mmkv

import android.app.Application

interface IMMKVService {
    fun withMKKV(application: Application)
    fun putData(key: String, value: Any)
    fun getInt(key: String, value: Int? = null): Int
    fun getFloat(key: String, value: Float? = null): Float
    fun getLong(key: String, value: Long? = null): Long
    fun getString(key: String, value: String? = null): String
    fun getBoolean(key: String, value: Boolean? = null): Boolean
    fun getByteArray(key: String, value: ByteArray? = null): ByteArray
    fun getSetString(key: String, value: Set<String>? = null): MutableSet<String>
}