package com.choo.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var person = arrayOf("나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위")

        var posterID = arrayOf(R.drawable.picture1, R.drawable.picture2, R.drawable.picture3, R.drawable.picture4, R.drawable.picture5, R.drawable.picture6, R.drawable.picture7, R.drawable.picture8, R.drawable.picture9)

        var spinner = findViewById<Spinner>(R.id.spinner1)
        var adapter : ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, person)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var imgPoster = findViewById<ImageView>(R.id.imgPoster)
                imgPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                imgPoster.setImageResource(posterID[p2])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}