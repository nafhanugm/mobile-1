package com.nafhan.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private var helloMessage = "Hello, welcome to my app!"
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        var username = ""
        var password = ""

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){

            inputUsername.maxLines = 1
            inputPassword.maxLines = 1

            inputUsername.imeOptions = android.view.inputmethod.EditorInfo.IME_ACTION_NEXT
            inputPassword.imeOptions = android.view.inputmethod.EditorInfo.IME_ACTION_DONE

            inputUsername.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    username = s.toString()
                }
            })

            inputPassword.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    password = s.toString()
                }
            })

            btnLogin.setOnClickListener {
                Intent(this@LoginActivity, HomeActivity::class.java).also {
                    it.putExtra("username", username)
                    it.putExtra("password", password)
                    startActivity(it)
                }
            }
        }

    }
}