package com.example.cleanarchitecture.di_dagger

import com.example.cleanarchitecture.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}