package com.example.showinteger

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        val rbEven = findViewById<RadioButton>(R.id.rbEven)
        val rbOdd = findViewById<RadioButton>(R.id.rbOdd)
        val rbSquare = findViewById<RadioButton>(R.id.rbSquare)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val listView = findViewById<ListView>(R.id.listView)
        val tvError = findViewById<TextView>(R.id.tvError)
        btnShow.setOnClickListener {
            val inputText = edtNumber.text.toString()
            if (inputText.isNotEmpty() && inputText.toIntOrNull() != null) {
                val n = inputText.toInt()
                tvError.visibility = TextView.GONE
                val numbers = mutableListOf<Int>()

                when {
                    rbEven.isChecked -> {
                        for (i in 0..n step 2) {
                            numbers.add(i)
                        }
                    }
                    rbOdd.isChecked -> {
                        for (i in 1..n step 2) {
                            numbers.add(i)
                        }
                    }
                    rbSquare.isChecked -> {
                        for (i in 0..n) {
                            if (sqrt(i.toDouble()) % 1 == 0.0) {
                                numbers.add(i)
                            }
                        }
                    }
                    else -> {
                        tvError.text = "Vui lòng chọn loại số"
                        tvError.visibility = TextView.VISIBLE
                    }
                }

                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numbers)
                listView.adapter = adapter
            } else {
                tvError.text = "Dữ liệu không hợp lệ"
                tvError.visibility = TextView.VISIBLE
            }
        }
    }
}