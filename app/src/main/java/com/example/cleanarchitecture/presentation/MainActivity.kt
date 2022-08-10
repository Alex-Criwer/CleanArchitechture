package com.example.cleanarchitecture.presentation


import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.app.App
import org.koin.androidx.viewmodel.ext.android.viewModel
import javax.inject.Inject


//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // для даггера
//    private lateinit var vm: MainViewModel
//    @Inject
//    lateinit var vmFactory: MainViewModelFactory

    //для Koin
    private val vm by viewModel<MainViewModel>()

    // для Hilt
    //private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //чтобы в инжект попала нужная переменная
//        (applicationContext as App).appComponent.inject(this)
//        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

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