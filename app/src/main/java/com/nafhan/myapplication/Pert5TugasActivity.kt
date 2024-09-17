package com.nafhan.myapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import com.nafhan.myapplication.databinding.ActivityTugas5Binding
import com.nafhan.myapplication.dialogs.ConfirmationDialog
import com.nafhan.myapplication.dialogs.DatePicker
import com.nafhan.myapplication.entity.TiketPemesanan


class Pert5TugasActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    private lateinit var binding: ActivityTugas5Binding
    private lateinit var provinces: Array<String>
    private lateinit var harga: Array<String>
//    public companion object val tiketPemesan = TiketPemesanan()
    companion object {
        private val tiketPemesanan = TiketPemesanan()
        public fun getTiketPemesanan(): TiketPemesanan {
            return tiketPemesanan
        }
    }

    private val countries = arrayOf(
        "Indonesia",
        "United States",
        "United Kingdom",
        "Germany",
        "France",
        "Australia",
        "Japan",
        "China",
        "Brazil",
        "Canada"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        provinces = resources.getStringArray(R.array.provinces)
        harga = resources.getStringArray(R.array.harga)

        with(binding) {
            val adapterCountry = ArrayAdapter(this@Pert5TugasActivity, android.R.layout.simple_spinner_item, provinces)
            spinnerCountry.adapter = adapterCountry
            spinnerCountry.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {
                        if (position == 0) {
                            (parent.getChildAt(0) as TextView).setTextColor("#828282".toColorInt())
                        } else {
                            (parent.getChildAt(0) as TextView).setTextColor(Color.BLACK)
                            getTiketPemesanan().setTujuan(provinces[position])
                            getTiketPemesanan().setHarga(harga[position].replace(" ", "").replace(".", "").toInt())
                        }

                    }
                    override fun onNothingSelected(parent: AdapterView<*>) {
                    }
                }

            btnTanggal.setOnClickListener {
                val datePicker = DatePicker()
                datePicker.show(supportFragmentManager, "date picker")
            }

            btnJam.setOnClickListener {
                val timePicker = com.nafhan.myapplication.dialogs.TimePicker()
                timePicker.show(supportFragmentManager, "time picker")
            }

            buttonPesan.setOnClickListener {
                var confirmDialog = ConfirmationDialog()
                getTiketPemesanan().setNamaPemesan(username.text.toString())
                if (getTiketPemesanan().getHarga() == 0) {
                    Toast.makeText(this@Pert5TugasActivity, "Pilih tujuan terlebih dahulu", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (getTiketPemesanan().getTanggalKeberangkatan() == "") {
                    Toast.makeText(this@Pert5TugasActivity, "Pilih tanggal terlebih dahulu", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (getTiketPemesanan().getJamKeberangkatan() == "") {
                    Toast.makeText(this@Pert5TugasActivity, "Pilih jam terlebih dahulu", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                confirmDialog.show(supportFragmentManager, "confirmation dialog")
            }
        }
    }

    override fun onDateSet(p0: android.widget.DatePicker?, p1: Int, p2: Int, p3:
    Int) {
        val selectedDate = "$p3/${p2 + 1}/$p1"
        with(binding) {
            btnTanggal.text = selectedDate
            btnTanggal.setTextColor(Color.BLACK)
            getTiketPemesanan().setTanggalKeberangkatan(selectedDate)
        }
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val selectedTime = "$hourOfDay:$minute"
        with(binding) {
            btnJam.text = selectedTime
            btnJam.setTextColor(Color.BLACK)
            getTiketPemesanan().setJamKeberangkatan(selectedTime)
        }
    }
}