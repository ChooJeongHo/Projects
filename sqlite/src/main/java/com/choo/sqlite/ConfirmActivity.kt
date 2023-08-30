package com.choo.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConfirmActivity : AppCompatActivity() {
    lateinit var tvConfirm : TextView
    lateinit var btnConfirm : Button
    lateinit var btnCancel : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        tvConfirm = findViewById(R.id.tvConfirm)
        btnConfirm = findViewById(R.id.btnConfirm)
        btnCancel = findViewById(R.id.btnCancel)

        btnConfirm.setOnClickListener {
            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("id", intent.getStringExtra("id"))
            intent.putExtra("pw", intent.getStringExtra("pw"))
            intent.putExtra("email", intent.getStringExtra("email"))
            intent.putExtra("phone", intent.getStringExtra("phone"))
            startActivity(intent)

        }

        btnCancel.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        tvConfirm.text = "입력한 내용은 id는 ${intent.getStringExtra("id")}, pass는 ${intent.getStringExtra("pw")}, 이메일은 ${intent.getStringExtra("email")}, 전화번호는 ${intent.getStringExtra("phone")}입니다."

    }
}