package com.custom.repository

import android.app.Application
import com.custom.mmkv.IMMKVService
import com.custom.mmkv.MMKVService
import com.custom.repository.basic.BaseRepository
import com.custom.repository.basic.IUseStatus
import com.custom.repository.proxy.MMKVInvocationHandler
import com.custom.repository.proxy.MMKVProxy
import java.lang.reflect.Proxy

class RepositoryService : BaseRepository() {
    lateinit var useStatus: IUseStatus
    lateinit var application: Application
    override fun initRepository(application: Application, status: IUseStatus) {
        //初始化仓库
        this.useStatus = status
        this.application = application
    }

    private fun initMMKV() {
        if (this.useStatus.useMMKV()) {
            //初始化存储方案
            val realService = MMKVProxy()
            val proxy = Proxy.newProxyInstance(
                MMKVProxy::class.java.classLoader,
                arrayOf(MMKVProxy::class.java),
                MMKVInvocationHandler(realService)
            ) as IMMKVService
            proxy.withMKKV(application)
        }
    }

    private fun iniDataBase() {
        if (this.useStatus.useDataBase()) {
            //初始化数据库
        }
    }

    private fun initNet() {
        if (this.useStatus.useNet()) {
            //初始化网络层
        }
    }
}