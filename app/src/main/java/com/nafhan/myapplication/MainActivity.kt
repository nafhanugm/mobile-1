package com.nafhan.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nafhan.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            txtNumber.text = number.toString()
            btnCount.setOnClickListener {
                number++
                txtNumber.text = number.toString()
            }
            btnToast.setOnClickListener {
                Toast.makeText(this@MainActivity, "Count $number",
                    Toast.LENGTH_SHORT).show()
            }
            btnMinus.setOnClickListener {
                if (number>0){
                    number--
                }
                txtNumber.text = number.toString();
            }
//            inputName.addTextChangedListener(object: TextWatcher{
//                override fun beforeTextChanged(
//                    s: CharSequence?,
//                    start: Int,
//                    count: Int,
//                    after: Int
//                ) {
//                }
//
//                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                }
//
//                override fun afterTextChanged(s: Editable?) {
//                    txtNama.setText(s)
//                }
//            })

            btnSwitch.setOnClickListener {
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            }

            btnSwitchPert3.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert2Activity::class.java))
            }

            btnSwitchPert3Tugas.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert2TugasActivity::class.java))
            }

            btnSwitchPert4Tugas.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert3TugasActivity::class.java))
            }

            btnSwitchPert5Tugas.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert4TugasActivity::class.java))
            }

            btnSwitchPert6Tugas.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert5TugasActivity::class.java))
            }
            btnSwitchPert8Tugas.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert8Activity::class.java))
            }

            btnSwitchPert9Tugas.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert9Activity::class.java))
            }

            btnSwitchPert10Tugas.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert10Activity::class.java))
            }

            btnSwitchPert11.setOnClickListener {
                startActivity(Intent(this@MainActivity, Pert11Activity::class.java))
            }
        }
    }
}