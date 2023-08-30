package com.choo.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var loginId : EditText
    lateinit var loginPw : EditText
    lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginId = findViewById(R.id.loginId)
        loginPw = findViewById(R.id.loginPw)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            // 회원가입 되어 있으면 로그인하고 SubMainActivity로 가고 회원가입 안되어 있으면 회원가입하라는 메시지를 띄우고 MemberActivity로 가기
            var id = intent.getStringExtra("id")
            var pw = intent.getStringExtra("pw")
            if (id == loginId.text.toString() && pw == loginPw.text.toString()) {
                var intent = Intent(this, SubMainActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            } else {
                // 회원정보에 없다는 알림과 함께 회원가입 페이지로 이동
                Toast.makeText(this, "회원정보가 없습니다. 회원가입을 해주세요.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MemberActivity::class.java)

                startActivity(intent)
            }

        }

    }
}