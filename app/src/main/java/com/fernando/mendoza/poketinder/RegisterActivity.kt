package com.fernando.mendoza.poketinder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RegisterActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtPassword2: EditText
    private lateinit var btnRegister: Button
    private lateinit var btnBackClose: FloatingActionButton
    private lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        edtPassword2 = findViewById(R.id.edtPassword2)
        btnRegister = findViewById(R.id.btnRegister)
        btnBackClose = findViewById(R.id.btnBackClose)

        sharedPreferencesRepository = SharedPreferencesRepository().apply {
            setSharedPreferences(this@RegisterActivity)
        }

        btnRegister.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()
            val confirmPassword = edtPassword2.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword) {
                sharedPreferencesRepository.saveUserEmail(email)
                sharedPreferencesRepository.saveUserPassword(password)

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btnBackClose.setOnClickListener {
            finish()
        }
    }
}
