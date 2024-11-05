package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityPert11DetailBinding
import com.squareup.picasso.Picasso

class Pert11DetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityPert11DetailBinding
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_AVATAR = "extra_avatar"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert11DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(EXTRA_NAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val avatar = intent.getStringExtra(EXTRA_AVATAR)
        binding.title.text = name
        binding.subtitle.text = email
        Picasso.get().load(avatar).into(binding.avatar)
    }
}