package com.example.smarttasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        val email = intent.getStringExtra("email")
        val code = intent.getStringExtra("code")
        val password = intent.getStringExtra("password")

        val txtInfo = findViewById<TextView>(R.id.txtInfo)
        txtInfo.text = "Email: $email\nCode: $code\nPassword: $password"

        val btnFinish = findViewById<Button>(R.id.btnFinish)
        btnFinish.setOnClickListener {
            finishAffinity() // đóng tất cả và thoát app
        }
    }
}

