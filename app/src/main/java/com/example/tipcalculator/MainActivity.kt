package com.example.tipcalculator

import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.R
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tipPercent.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tipPercent1.text = p1.toString() + "%"
                calculateFunction()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        }

        )
        numberPeople.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                numberPeople1.text = p1.toString()
                calculateFunction()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        }

        )
        calculate.setOnClickListener {
            calculateFunction()

        }

    }
    fun calculateFunction()
    {
        if (billAmount.length() > 0 && numberPeople.progress>0) {
            var billAmount = billAmount.text.toString().toInt()
            var tipPercent = tipPercent.progress
            var numpeople = numberPeople.progress

            var tipAmount = (billAmount * tipPercent) / 100

            var total = billAmount + tipAmount

            var each = (tipAmount +billAmount) / numpeople


            display.text = "Total: ₹" + total.toString() + " Each: ₹" + each.toString()


        }
        else{
            Toast.makeText(applicationContext, "Please enter Bill Amount", Toast.LENGTH_LONG).show()
        }
    }
}