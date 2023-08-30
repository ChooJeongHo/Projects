package com.choo.popularvote

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var voteCount = IntArray(9) // 0~8
        for(i in 0..8)
            voteCount[i] = 0

        var image = arrayOfNulls<ImageView>(9)

        var imageID = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9)

        var imgName = arrayOf("나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위")

        // 이미지 클릭하면 클릭 횟수를 카운트
        for(i in imageID.indices) {
            image[i] = findViewById<ImageView>(imageID[i])
            image[i]!!.setOnClickListener {
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + ": 총 " + voteCount[i] + "표", Toast.LENGTH_SHORT).show()
            }
        }

        var btnFinish = findViewById<Button>(R.id.btnResult)
        btnFinish.setOnClickListener {
            // 결과 액티비티로 이동
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imgName)
            startActivity(intent)
        }
    }
}