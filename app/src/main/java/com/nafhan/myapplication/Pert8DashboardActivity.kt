package com.nafhan.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityTugas8dashboardBinding

class Pert8DashboardActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTugas8dashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas8dashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra("username")
        with(binding){
            welcomeUsername.text = "Welcome, $username"
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_keluar, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_keluar -> {
               Intent(this@Pert8DashboardActivity, Pert8Activity::class.java).also {
                   startActivity(it)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}