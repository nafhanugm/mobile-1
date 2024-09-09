package com.nafhan.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nafhan.myapplication.databinding.ActivityTugas4Binding
class Pert4TugasActivity: AppCompatActivity(){
    private lateinit var binding: ActivityTugas4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            buttonRegister.setOnClickListener {
                val sharedPref = getSharedPreferences("register", MODE_PRIVATE)
                val editor = sharedPref.edit()

                val usersString = sharedPref.getString("users", null)
                val users = if (usersString != null) {
                    val gson = Gson()
                    val type = object : TypeToken<MutableList<HashMap<String, String>>>() {}.type
                    gson.fromJson<MutableList<HashMap<String, String>>>(usersString, type)
                } else {
                    mutableListOf()
                }
                val newUser = hashMapOf("username" to username.text.toString(),"phone" to phone.text.toString() ,"email" to email.text.toString(), "password" to password.text.toString())
                users.add(newUser)
                val gson = Gson()
                val updatedUsersString = gson.toJson(users)
                editor.putString("users", updatedUsersString)
                editor.apply()
                startActivity(Intent(this@Pert4TugasActivity, Pert4TugasLoginActivity::class.java))
                finish()
            }
        }
    }
}