package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(val userStorage: UserStorage): UserRepository {

    override fun saveName(param: SaveUserNameParam): Boolean {
        return userStorage.save(userToStorage(param))
    }

    override fun getName(): GetUserNameParam {
        return userToRepository(userStorage.get())
    }

    private fun userToStorage (param: SaveUserNameParam): User {
        return User(firstName = param.userName, lastName = "")
    }

    private fun userToRepository(user: User): GetUserNameParam {
        return GetUserNameParam(userName = user.firstName, userSurname = user.lastName)
    }
}