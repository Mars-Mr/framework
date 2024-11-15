package com.custom.repository.basic

import android.app.Application

abstract class BaseRepository {

    abstract fun initRepository(application: Application,status: IUseStatus);

}