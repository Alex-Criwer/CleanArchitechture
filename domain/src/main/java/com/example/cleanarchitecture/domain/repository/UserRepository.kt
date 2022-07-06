package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam

interface UserRepository {
    fun saveName(param: SaveUserNameParam): Boolean

    fun getName(): GetUserNameParam
}