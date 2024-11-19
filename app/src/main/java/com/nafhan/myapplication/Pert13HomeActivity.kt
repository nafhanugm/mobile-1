package com.nafhan.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.nafhan.myapplication.dao.VoterDao
import com.nafhan.myapplication.database.VoterDatabase
import com.nafhan.myapplication.databinding.ActivityPert13HomeBinding
import kotlinx.coroutines.launch

class Pert13HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityPert13HomeBinding
    private lateinit var db: VoterDatabase
    private lateinit var voterDao: VoterDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPert13HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = VoterDatabase.getDatabase(this)
        voterDao = db.voterDao()

        setupViews()
        observeVoters()

        binding.btnAddData.setOnClickListener {
            startActivity(Intent(this, Pert13AddActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, Pert13LoginActivity::class.java))
            finish()
        }
    }

    private fun setupViews() {
        binding.rvVoters.layoutManager = LinearLayoutManager(this)
         binding.rvVoters.adapter = VoterAdapter(
             voters = emptyList(),
             onDeleteClick = { position ->
                    val voter = (binding.rvVoters.adapter as VoterAdapter).voters[position]
                    lifecycleScope.launch {
                        voterDao.deleteVoter(voter)
                    }
             },
             onEditClick = { position ->
                    val voter = (binding.rvVoters.adapter as VoterAdapter).voters[position]
                    startActivity(Intent(this, Pert13EditActivity::class.java).apply {
                        putExtra("voter_id", voter.id)
                    })
             },
             onViewClick = { position ->
                    val voter = (binding.rvVoters.adapter as VoterAdapter).voters[position]
                    startActivity(Intent(this, Pert13DetailActivity::class.java).apply {
                        putExtra("voter_id", voter.id)
                    })
             }
         )
    }

    private fun observeVoters() {
        lifecycleScope.launch {
            voterDao.getAllVoters().collect { voters ->
                (binding.rvVoters.adapter as VoterAdapter).apply {
                    this.voters = voters
                    notifyDataSetChanged()
                }
            }
        }
    }
}