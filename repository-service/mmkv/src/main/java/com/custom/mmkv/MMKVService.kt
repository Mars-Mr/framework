package com.custom.mmkv

import android.app.Application
import com.tencent.mmkv.MMKV

@Suppress("UNCHECKED_CAST")
class MMKVService private constructor() : IMMKVService {

    private var initialized: Boolean = false


    companion object {
        @Volatile
        private var instance: MMKVService? = null

        fun getInstance(): MMKVService {
            if (instance == null) {
                synchronized(MMKVService::class.java) {
                    if (instance == null) {
                        instance = MMKVService()
                    }
                }
            }
            return instance!!
        }
    }

    override fun withMKKV(application: Application) {
        if (!initialized) {
            initialized = true
            MMKV.initialize(application)
        }
    }


    override fun putData(key: String, value: Any) {
        when (value) {
            is Int -> {
                MMKV.defaultMMKV().putInt(key, value)
            }

            is String -> {
                MMKV.defaultMMKV().putString(key, value)
            }

            is Boolean -> {
                MMKV.defaultMMKV().putBoolean(key, value)
            }

            is Long -> {
                MMKV.defaultMMKV().putLong(key, value)
            }

            is Float -> {
                MMKV.defaultMMKV().putFloat(key, value)
            }

            is ByteArray -> {
                MMKV.defaultMMKV().putBytes(key, value)
            }

            is Set<*> -> {
                val element = value.firstOrNull()
                element?.let {
                    if (it is String) {
                        MMKV.defaultMMKV().putStringSet(key, value as Set<String>)
                    }
                }
            }

            else -> {
                throw ClassNotFoundException("This type is not supported")
            }
        }
    }

    override fun getInt(key: String, value: Int?): Int {
        value?.let {
            return MMKV.defaultMMKV().getInt(key, value)
        }
        return MMKV.defaultMMKV().getInt(key, Int.MAX_VALUE)
    }

    override fun getFloat(key: String, value: Float?): Float {
        value?.let {
            return MMKV.defaultMMKV().getFloat(key, value)
        }
        return MMKV.defaultMMKV().getFloat(key, Float.MAX_VALUE)
    }

    override fun getLong(key: String, value: Long?): Long {
        value?.let {
            return MMKV.defaultMMKV().getLong(key, value)
        }
        return MMKV.defaultMMKV().getLong(key, Long.MAX_VALUE)
    }

    override fun getString(key: String, value: String?): String {
        value?.let {
            val result = MMKV.defaultMMKV().getString(key, value)
            result?.let {
                return it
            }
            return ""
        }
        val result = MMKV.defaultMMKV().getString(key, "")
        result?.let {
            return it
        }
        return ""
    }

    override fun getBoolean(key: String, value: Boolean?): Boolean {
        value?.let {
            MMKV.defaultMMKV().getBoolean(key, value)
        }
        return MMKV.defaultMMKV().getBoolean(key, false)
    }

    override fun getByteArray(key: String, value: ByteArray?): ByteArray {
        value?.let {
            return MMKV.defaultMMKV().getBytes(key, value)
        }
        return MMKV.defaultMMKV().getBytes(key, null)
    }

    override fun getSetString(key: String, value: Set<String>?): MutableSet<String> {
        value?.let {
            val result = MMKV.defaultMMKV().getStringSet(key, value)
            result?.let {
                return it
            }
        }
        val result = MMKV.defaultMMKV().getStringSet(key, null)
        result?.let {
            return it
        }
        return emptySet<String>().toMutableSet()
    }
}