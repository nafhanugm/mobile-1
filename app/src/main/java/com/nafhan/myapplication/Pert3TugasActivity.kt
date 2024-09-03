package com.nafhan.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nafhan.myapplication.databinding.ActivityTugas3Binding

class Pert3TugasActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTugas3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            txtResult.text = ""
            txtHistory.text = ""

            btn0.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "0"
            }

            btn1.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "1"
            }

            btn2.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "2"
            }

            btn3.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "3"
            }

            btn4.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "4"
            }

            btn5.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "5"
            }

            btn6.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "6"
            }

            btn7.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "7"
            }

            btn8.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "8"
            }

            btn9.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "9"
            }

            btnPlus.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "+"
            }

            btnMinus.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "-"
            }

            btnMultiply.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "*"
            }

            btnDivide.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "/"
            }

            btnAc.setOnClickListener {
                txtResult.text = ""
            }

            btnDot.setOnClickListener {
                txtResult.text = txtResult.text.toString() + "."
            }

            btnEqual.setOnClickListener {
                val result = calculate(txtResult.text.toString())
                txtHistory.text = txtResult.text.toString()
                txtResult.text = result.toString()
            }
        }
    }

    fun calculate(text: String): Float {
        val result = text.split("+", "-", "*", "/")
        var total:Float = 0f
        var operator = ""
        for (i in result.indices){
            if (i == 0){
                total = result[i].toFloat()
            } else {
                if (operator == "+"){
                    total += result[i].toFloat()
                } else if (operator == "-"){
                    total -= result[i].toFloat()
                } else if (operator == "*"){
                    total *= result[i].toFloat()
                } else if (operator == "/"){
                    total /= result[i].toFloat()
                }
            }
            operator = text[result[i].length].toString()
        }
        return total
    }
}