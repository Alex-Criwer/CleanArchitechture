package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()
        if(oldUserName.userName == param.userName) {
            return true
        }
        return userRepository.saveName(param = param)
    }
}