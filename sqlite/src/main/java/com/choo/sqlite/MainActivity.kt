package com.choo.sqlite

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var edtId : EditText
    lateinit var edtPw : EditText
    lateinit var edtEmail : EditText
    lateinit var edtPhone : EditText
    lateinit var btnJoin : Button
    lateinit var btnSelect : Button
    lateinit var myHelper : myDBHelper
    lateinit var sqlDB : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtId = findViewById(R.id.edtId)
        edtPw = findViewById(R.id.edtPw)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhone = findViewById(R.id.edtPhone)

        btnJoin = findViewById(R.id.btnJoin)
        btnSelect = findViewById(R.id.btnSelect)

        myHelper = myDBHelper(this)

        btnJoin.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO memberList VALUES ('" + edtId.text.toString() + "', '" + edtPw.text.toString() + "', '" + edtEmail.text.toString() + "', '" + edtPhone.text.toString() + "');")
            sqlDB.close()
            edtId.setText("")
            edtPw.setText("")
            edtEmail.setText("")
            edtPhone.setText("")
            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra("id", edtId.text.toString())
            intent.putExtra("pw", edtPw.text.toString())
            intent.putExtra("email", edtEmail.text.toString())
            intent.putExtra("phone", edtPhone.text.toString())
            startActivity(intent)
        }

        btnSelect.setOnClickListener {
            sqlDB = myHelper.readableDatabase
            var cursor = sqlDB.rawQuery("SELECT * FROM memberList;", null)
            var strNames = "아이디" + "\r\n" + "========" + "\r\n"
            var strPws = "비밀번호" + "\r\n" + "========" + "\r\n"
            var strEmails = "이메일" + "\r\n" + "========" + "\r\n"
            var strPhones = "전화번호" + "\r\n" + "========" + "\r\n"
            while (cursor.moveToNext()) {
                strNames += cursor.getString(0) + "\r\n"
                strPws += cursor.getString(1) + "\r\n"
                strEmails += cursor.getString(2) + "\r\n"
                strPhones += cursor.getString(3) + "\r\n"
            }
            cursor.close()
            sqlDB.close()
            edtId.setText(strNames)
            edtPw.setText(strPws)
            edtEmail.setText(strEmails)
            edtPhone.setText(strPhones)
        }
    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "testMember", null, 1) {
        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL("CREATE TABLE memberList (id CHAR(20) PRIMARY KEY, pw CHAR(20), email CHAR(30), phone CHAR(20));")
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("DROP TABLE IF EXISTS memberList")
            onCreate(p0)
        }
    }
}