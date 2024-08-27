package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityTugas2Binding


class Pert2TugasActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTugas2Binding
    var isPlaying = false
    var progressBarValue = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            imgMusic.setBackgroundResource(R.drawable.image_music)
            btnPlay.setOnClickListener {
                if (isPlaying){
                    btnPlay.setImageDrawable(getDrawable(R.drawable.playbutton))
                    isPlaying = false
                } else {
                    btnPlay.setImageDrawable(getDrawable(R.drawable.stopbutton))
                    isPlaying = true

                    Thread(Runnable {
                        while (isPlaying){
                            Thread.sleep(100)
                            progressBarValue += 1
                            if (progressBarValue > 100){
                                progressBarValue = 0
                            }
                            runOnUiThread {
                                seekBar?.setProgress(progressBarValue, true)
                            }
                        }
                    }).start()
                }
            }
        }
    }
}