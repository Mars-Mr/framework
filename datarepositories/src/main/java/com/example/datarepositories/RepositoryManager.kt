package com.example.datarepositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.net.INetworkRequiredInfo
import com.example.net.NetworkApi
import com.example.net.response.NetWorkResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RepositoryManager {


    companion object {

        val mContext: Application? = null
        val TAG: String = RepositoryManager::class.java.name

        init {
            NetworkApi.Companion.init(TestNetWork(mContext!!))
        }

        suspend fun hello() {
            GlobalScope.launch {
                when (val reault = NetworkApi.getDataMethod()) {
                    is NetWorkResponse.Success -> {
                        Log.e(TAG, "hello:Success ")
                    }

                    is NetWorkResponse.ApiError -> {
                        Log.e(TAG, "hello:ApiError ")
                    }

                    is NetWorkResponse.NetworkError -> {
                        Log.e(TAG, "hello:NetworkError ")
                    }

                    is NetWorkResponse.UnknownError -> {
                        Log.e(TAG, "hello:UnknownError ")
                    }
                }
            }
        }
    }


}