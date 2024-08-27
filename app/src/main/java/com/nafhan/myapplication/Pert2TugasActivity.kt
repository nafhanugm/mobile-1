package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityTugas2Binding


class Pert2Tugas: AppCompatActivity() {
    private lateinit var binding: ActivityTugas2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
        }
    }
}