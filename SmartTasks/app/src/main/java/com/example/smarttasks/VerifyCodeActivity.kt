package com.example.smarttasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class VerifyCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_code)

        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val edtCode = findViewById<EditText>(R.id.edtCode)
        val btnNext = findViewById<Button>(R.id.btnNext)

        val email = intent.getStringExtra("email")
        txtEmail.text = "Code sent to: $email"

        btnNext.setOnClickListener {
            val code = edtCode.text.toString()
            val intent = Intent(this, ResetPasswordActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("code", code)
            startActivity(intent)
        }
    }
}
