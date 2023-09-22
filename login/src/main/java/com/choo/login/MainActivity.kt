package com.choo.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btnLogin : Button
    lateinit var btnJoin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        btnJoin = findViewById(R.id.btnJoin)

        btnLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnJoin.setOnClickListener {
            var intent = Intent(this, MemberActivity::class.java)
            startActivity(intent)
        }

    }

    // onPause() 메소드는 액티비티가 일시정지 상태가 되었을 때 호출되는 메소드
    override fun onPause() {
        super.onPause()
    }

    // onResume() 메소드는 액티비티가 다시 시작되었을 때 호출되는 메소드
    override fun onResume() {
        super.onResume()
    }

    // onStop() 메소드는 액티비티가 화면에서 사라졌을 때 호출되는 메소드
    override fun onStop() {
        super.onStop()
    }

    // onDestroy() 메소드는 액티비티가 소멸되었을 때 호출되는 메소드
    override fun onDestroy() {
        super.onDestroy()
    }
}