package com.example.cleanarchitecture.data.storage

import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}