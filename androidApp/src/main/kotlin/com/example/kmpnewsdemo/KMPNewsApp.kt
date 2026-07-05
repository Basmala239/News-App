package com.example.kmpnewsdemo

import android.app.Application
import com.example.kmpnewsdemo.data.local.appContext
import com.example.kmpnewsdemo.di.initKoin
import org.koin.android.ext.koin.androidContext

class KMPNewsApp: Application() {
    override fun onCreate() {
        super.onCreate()

        appContext = this

        initKoin {
            androidContext(this@KMPNewsApp)
        }

    }
}