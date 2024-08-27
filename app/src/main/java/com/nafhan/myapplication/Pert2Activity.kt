package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityPert2Binding

class Pert2Activity: AppCompatActivity() {
    private lateinit var binding: ActivityPert2Binding
    var isChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnBookmark.setOnClickListener {
                isChecked = !isChecked
                if (isChecked) {
                    btnBookmark.text = "Bookmarked"
                    btnBookmark.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_bookmark_24, 0, 0, 0)
                } else {
                    btnBookmark.text = "Bookmark"
                    btnBookmark.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_bookmark_border_24, 0, 0, 0)
                }
            }
        }
    }
}