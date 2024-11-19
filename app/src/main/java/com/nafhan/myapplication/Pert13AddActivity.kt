package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.nafhan.myapplication.dao.VoterDao
import com.nafhan.myapplication.database.VoterDatabase
import com.nafhan.myapplication.databinding.ActivityPert13AddBinding
import com.nafhan.myapplication.entity.Voter
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class Pert13AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPert13AddBinding
    private lateinit var voterDao: VoterDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert13AddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        voterDao = VoterDatabase.getDatabase(this).voterDao()

        binding.btnSave.setOnClickListener {
            saveVoter()
        }


    }

    private fun saveVoter() {
        val name = binding.etName.text.toString()
        val nik = binding.etNik.text.toString()
        val address = binding.etAddress.text.toString()
        val gender = if (binding.rbMale.isChecked) "Laki Laki" else "Perempuan"


        if (validateInput(name, nik, address)) {
            lifecycleScope.launch {
                voterDao.insertVoter(
                    Voter(
                        name = name,
                        nik = nik,
                        gender = gender,
                        address = address
                    )
                )
                finish()
            }
        }
    }

    private fun validateInput(name: String, nik: String, address: String): Boolean {
        return name.isNotBlank() && nik.isNotBlank() && address.isNotBlank()
    }


}