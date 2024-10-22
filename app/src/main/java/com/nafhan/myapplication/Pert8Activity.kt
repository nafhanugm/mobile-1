package com.nafhan.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
import com.nafhan.myapplication.databinding.FragmentHomeBinding
import com.nafhan.myapplication.databinding.FragmentQuizBinding


class Pert8Activity: AppCompatActivity() {
    private lateinit var binding: ActivityAfteruas1Binding
    private lateinit var bindingHome: FragmentHomeBinding
    private lateinit var bindingQuiz: FragmentQuizBinding

    companion object {
        public lateinit var viewPagers: ViewPager2
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfteruas1Binding.inflate(layoutInflater)
        bindingHome = FragmentHomeBinding.inflate(layoutInflater)
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF525BFF")))
        bindingQuiz = FragmentQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            bindingHome.buttonRegister.setOnClickListener {
                Toast.makeText(this@Pert8Activity, "Register", Toast.LENGTH_SHORT).show()
            }

            val sectionsPagerAdapter = SectionsPagerAdapter(this@Pert8Activity)
            viewPagers = viewPager
            viewPagers.adapter = sectionsPagerAdapter
            val tabs: TabLayout = tabLayout
            TabLayoutMediator(tabs, viewPagers) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true;
    }
}