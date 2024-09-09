package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityTugas4HomepageBinding

class Pert4TugasHomeActivity: AppCompatActivity(){
    private lateinit var binding: ActivityTugas4HomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas4HomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            val username = intent.getStringExtra("username")
            val phone = intent.getStringExtra("phone")
            val email = intent.getStringExtra("email")

            welcomeUsername.text = "Welcome, $username"
            phoneRegistered.text = "Your phone $phone has been registered"
            emailActivated.text = "Your email $email has been activated"


        }
    }
}