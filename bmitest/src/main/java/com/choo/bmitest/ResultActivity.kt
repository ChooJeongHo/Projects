package com.choo.bmitest

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    lateinit var tvResult : TextView
    lateinit var imgView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvResult = findViewById(R.id.tvResult)
        imgView = findViewById(R.id.imgView)

        var height = intent.getDoubleExtra("height", 0.0)
        var weight = intent.getDoubleExtra("weight", 0.0)
        var bmi = weight / Math.pow(height / 100, 2.0)

        if(bmi < 18.5) {
            tvResult.text = "저체중"
            imgView.setImageResource(R.drawable.img5)
        } else if(bmi < 23) {
            tvResult.text = "정상"
            imgView.setImageResource(R.drawable.img1)
        } else if(bmi < 25) {
            tvResult.text = "과체중"
            imgView.setImageResource(R.drawable.img2)
        } else if(bmi < 30) {
            tvResult.text = "1단계 비만"
            imgView.setImageResource(R.drawable.img3)
        } else if(bmi < 35){
            tvResult.text = "2단계 비만"
            imgView.setImageResource(R.drawable.img4)
        } else {
            tvResult.text = "고도 비만"
            imgView.setImageResource(R.drawable.img5)
        }

    }
}