package com.choo.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MemberActivity : AppCompatActivity() {

    lateinit var edtId : EditText
    lateinit var edtPw : EditText
    lateinit var edtName : EditText
    lateinit var edtEmail : EditText
    lateinit var btnJoin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)

        edtId = findViewById(R.id.edtId)
        edtPw = findViewById(R.id.edtPw)
        edtName = findViewById(R.id.edtName)
        edtEmail = findViewById(R.id.edtEmail)
        btnJoin = findViewById(R.id.btnJoin)

        btnJoin.setOnClickListener {
            var id = edtId.text.toString()
            var pw = edtPw.text.toString()
            var name = edtName.text.toString()
            var email = edtEmail.text.toString()

            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("pw", pw)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}