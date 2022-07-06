package com.example.cleanarchitecture.data.storage

import android.content.Context
import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam

private val SHARED_NAME = "SHARED_NAME"
private val KEY_FIRST_NAME = "KEY_FIRST_NAME"
private val KEY_LAST_NAME = "KEY_LAST_NAME"

class SharedPrefUserStorage(context: Context): UserStorage {
    val sharedPrefs = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPrefs.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPrefs.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val userName = sharedPrefs.getString(KEY_FIRST_NAME, "") ?: ""
        val userSurname = sharedPrefs.getString(KEY_LAST_NAME, "") ?: ""
        return User(firstName = userName, lastName = userSurname)
    }
}