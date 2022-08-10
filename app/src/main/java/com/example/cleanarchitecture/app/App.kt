package com.example.cleanarchitecture.app

import android.app.Application
import com.example.cleanarchitecture.di_dagger.AppComponent
import com.example.cleanarchitecture.di_dagger.AppModule
import com.example.cleanarchitecture.di_dagger.DaggerAppComponent
import com.example.cleanarchitecture.di_koin.appModule
import com.example.cleanarchitecture.di_koin.dataModule
import com.example.cleanarchitecture.di_koin.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// тут мы запустим di, каждый раз при входе в приложение

//@HiltAndroidApp
class App: Application() {
    //lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        //Dagger
        //appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }

    }
}