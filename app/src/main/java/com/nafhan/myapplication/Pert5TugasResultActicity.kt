package com.nafhan.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityTugas5ResultBinding
import com.nafhan.myapplication.entity.TiketPemesanan

class Pert5TugasResultActicity: AppCompatActivity() {
    private lateinit var binding: ActivityTugas5ResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas5ResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            val tiket = @Suppress("DEPRECATION") intent.getSerializableExtra("tiket") as TiketPemesanan
            username.text = tiket.getNamaPemesan()
            jam.text = tiket.getJamKeberangkatan()
            tanggal.text = tiket.getTanggalKeberangkatan()
            tujuan.text = tiket.getTujuan()
        }

    }
}