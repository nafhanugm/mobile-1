package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.nafhan.myapplication.dao.VoterDao
import com.nafhan.myapplication.database.VoterDatabase
import com.nafhan.myapplication.databinding.ActivityPert13EditBinding
import com.nafhan.myapplication.entity.Voter
import kotlinx.coroutines.launch

class Pert13EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPert13EditBinding
    private lateinit var voterDao: VoterDao
    private var voterId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert13EditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        voterDao = VoterDatabase.getDatabase(this).voterDao()
        voterId = intent.getIntExtra("voter_id", 0)

        loadVoterData()

        binding.btnSave.setOnClickListener {
            updateVoter()
        }
    }

    private fun loadVoterData() {
        lifecycleScope.launch {
            voterDao.getVoterById(voterId).collect { voter ->
                binding.etName.setText(voter.name)
                binding.etNik.setText(voter.nik)
                if (voter.gender == "Laki Laki") {
                    binding.rbMale.isChecked = true
                } else {
                    binding.rbFemale.isChecked = true
                }
                binding.etAddress.setText(voter.address)
            }
        }
    }

    private fun updateVoter() {
        val name = binding.etName.text.toString()
        val nik = binding.etNik.text.toString()
        val gender = if (binding.rbMale.isChecked) "Laki Laki" else "Perempuan"
        val address = binding.etAddress.text.toString()

        if (validateInput(name, nik, address)) {
            lifecycleScope.launch {
                voterDao.updateVoter(Voter(id = voterId, name = name, nik = nik, gender = gender, address = address))
                finish()
            }
        }
    }

    private fun validateInput(name: String, nik: String, address: String): Boolean {
        return name.isNotBlank() && nik.isNotBlank() && address.isNotBlank()
    }
}