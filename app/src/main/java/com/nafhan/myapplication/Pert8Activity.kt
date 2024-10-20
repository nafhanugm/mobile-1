package com.nafhan.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nafhan.myapplication.databinding.ActivityAfteruas1Binding

class Pert8Activity: AppCompatActivity() {
    private lateinit var binding: ActivityAfteruas1Binding
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfteruas1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            val sectionsPagerAdapter = SectionsPagerAdapter(this@Pert8Activity)
            val viewPager: ViewPager2 = viewPager
            viewPager.adapter = sectionsPagerAdapter
            val tabs: TabLayout = tabLayout
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_materi -> {
                // Logika untuk melihat skor
                Toast.makeText(this, "Materi", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_quiz -> {
                Toast.makeText(this, "Quiz", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}