package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.nafhan.myapplication.dao.VoterDao
import com.nafhan.myapplication.database.VoterDatabase
import com.nafhan.myapplication.databinding.ActivityPert13DetailBinding
import kotlinx.coroutines.launch

class Pert13DetailActivity: AppCompatActivity(){
    private lateinit var binding: ActivityPert13DetailBinding
    private lateinit var voterDao: VoterDao
    private var voterId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert13DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        voterDao = VoterDatabase.getDatabase(this).voterDao()
        voterId = intent.getIntExtra("voter_id", 0)

        loadVoterData()
    }

    private fun loadVoterData() {
        lifecycleScope.launch {
            voterDao.getVoterById(voterId).collect { voter ->
                binding.tvName.setText(voter.name)
                binding.tvNik.setText(voter.nik)
                if (voter.gender == "Laki Laki") {
                    binding.tvGender.setText("Laki Laki")
                } else {
                    binding.tvGender.setText("Perempuan")
                }
                binding.tvAddress.setText(voter.address)
            }
        }
    }
}