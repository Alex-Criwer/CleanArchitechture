package com.example.cleanarchitecture.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userStorage by lazy { SharedPrefUserStorage(context = applicationContext) }
    private val repositoryImpl  by lazy {UserRepositoryImpl(userStorage = userStorage)}
    private val getUserNameUseCase by lazy {GetUserNameUseCase(userRepository = repositoryImpl)}
    private val saveUserNameUseCase by lazy {SaveUserNameUseCase(userRepository = repositoryImpl)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            val result = saveUserNameUseCase.execute(SaveUserNameParam(text))
            dataTextView.text = "Save result is $result"
        }

        receiveButton.setOnClickListener {
            val userInfo = getUserNameUseCase.execute()
            dataTextView.text = "${userInfo.userName} ${userInfo.userSurname}"
        }
    }
}