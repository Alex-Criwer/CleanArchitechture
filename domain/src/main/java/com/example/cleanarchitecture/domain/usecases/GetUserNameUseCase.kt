package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): GetUserNameParam {
        return userRepository.getName()
    }
}