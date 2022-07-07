package com.example.cleanarchitecture.app

import android.app.Application
import com.example.cleanarchitecture.di.appModule
import com.example.cleanarchitecture.di.dataModule
import com.example.cleanarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

// тут мы запустим di, каждый раз при входе в приложение
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}