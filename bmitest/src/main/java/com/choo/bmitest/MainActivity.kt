package com.choo.bmitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var etHeight : EditText
    lateinit var etWeight : EditText
    lateinit var btnResult : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        btnResult = findViewById(R.id.btnResult)

        btnResult.setOnClickListener {
            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", etHeight.text.toString().toDouble())
            intent.putExtra("weight", etWeight.text.toString().toDouble())
            startActivity(intent)
        }
    }
}