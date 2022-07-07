package com.example.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {
    private val userStorage by lazy { SharedPrefUserStorage(context = context) }
    private val repositoryImpl  by lazy { UserRepositoryImpl(userStorage = userStorage) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = repositoryImpl) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = repositoryImpl) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}