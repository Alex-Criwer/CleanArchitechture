package com.example.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import javax.inject.Inject

// хранит в себе состояние активити

// view model должна быть без контекста! она ничего не знает об активити! + из нее ничего не возвращаем

//@HiltViewModel
class MainViewModel /*@Inject constructor*/(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable


    fun save(text: String) {
        val result = saveUserNameUseCase.execute(SaveUserNameParam(text))
        resultLiveMutable.value = "Save result is $result"
    }

    fun load() {
        val userInfo = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userInfo.userName} ${userInfo.userSurname}"
    }

    // вызывается, когда выходим из приложения, view model по сути синглетон
    // в рамках жизненного цикла активити, потому что активити будет
    // получать ссылку на существующую view model при пересоздании
    override fun onCleared() {
        super.onCleared()
    }
}