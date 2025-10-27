package com.example.smarttasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            val email = edtEmail.text.toString()
            val intent = Intent(this, VerifyCodeActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}
