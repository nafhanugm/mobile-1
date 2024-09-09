package com.nafhan.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nafhan.myapplication.databinding.ActivityTugas4LoginBinding

class Pert4TugasLoginActivity: AppCompatActivity(){
    private lateinit var binding: ActivityTugas4LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas4LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("register", MODE_PRIVATE)
        with(binding) {
            btnLogin.setOnClickListener {
                val usersString = sharedPreferences.getString("users", null)
                val gson = Gson()
                val type = object : TypeToken<MutableList<HashMap<String, String>>>() {}.type
                val users = gson.fromJson<MutableList<HashMap<String, String>>>(usersString, type)

                // Cek apakah email dan password cocok
                val user = users?.find { it["username"] == username.text.toString() && it["password"] == password.text.toString() }
                Log.d("USER", usersString.toString())
                Log.d("Input", username.text.toString() + " " + password.text.toString())
                if (user != null) {
                    // Berhasil login, pindah ke HomeActivity dengan membawa data user
                    val intent = Intent(this@Pert4TugasLoginActivity, Pert4TugasHomeActivity::class.java)
                    // username
                    intent.putExtra("username", user["username"])
                    // email
                    intent.putExtra("email", user["email"])
                    // phone
                    intent.putExtra("phone", user["phone"])
                    startActivity(intent)

                    finish()
                } else {
                    Toast.makeText(this@Pert4TugasLoginActivity, "Username atau password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}