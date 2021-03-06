package com.example.cleanarchitecture.presentation


import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecture.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    //private lateinit var vm: MainViewModel
    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // это если не через di
        //vm = ViewModelProvider(this, MainViewModelFactory(applicationContext)).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        // подписка на изменение данных, как только resultLive поменяется, вызовется этот кусок кода
        // + она сама отпишется, она очень умная
        vm.resultLive.observe(this) { text ->
            dataTextView.text = text
        }

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            vm.save(text)
        }

        receiveButton.setOnClickListener {
            vm.load()
        }
    }
}