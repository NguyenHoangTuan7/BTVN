package com.example.smarttasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val email = intent.getStringExtra("email")
        val code = intent.getStringExtra("code")

        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val edtConfirm = findViewById<EditText>(R.id.edtConfirm)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            val password = edtPassword.text.toString()
            val confirm = edtConfirm.text.toString()
            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("code", code)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }
}
