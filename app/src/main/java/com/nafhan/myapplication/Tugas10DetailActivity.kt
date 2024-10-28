package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityTugas10DetailBinding

class Tugas10DetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTugas10DetailBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SUBJECT = "extra_subject"
        const val EXTRA_TEXT = "extra_text"
        const val EXTRA_DATE = "extra_date"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas10DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val subject = intent.getStringExtra(EXTRA_SUBJECT)
        val text = intent.getStringExtra(EXTRA_TEXT)
        val date = intent.getStringExtra(EXTRA_DATE)

        with(binding) {
            tvName.text = name
            tvSubject.text = subject
            tvText.text = text
            tvTanggal.text = date

            ivBack.setOnClickListener {
                finish()
            }
        }
    }
}