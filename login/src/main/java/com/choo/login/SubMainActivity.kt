package com.choo.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SubMainActivity : AppCompatActivity() {

    lateinit var tvConnect : TextView
    lateinit var btnMain : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_main)

        tvConnect = findViewById(R.id.tvConnect)
        btnMain = findViewById(R.id.btnMain)


        //로그인 하면 아이디님 접속하셨군요 라는 메시지를 출력하기
        var id = intent.getStringExtra("id")
        tvConnect.text = "${id}님 접속하셨군요"

        btnMain.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}