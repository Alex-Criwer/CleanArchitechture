package com.example.cleanarchitecture.di_koin

import com.example.cleanarchitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel>{
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get())
    }
}