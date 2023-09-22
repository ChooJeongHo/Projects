package com.choo.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var et : EditText
    lateinit var btnLv : Button
    lateinit var lv : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et = findViewById(R.id.et)
        btnLv = findViewById(R.id.btnLv)
        lv = findViewById(R.id.lv)
        val list = ArrayList<String>()

        //버튼을 누르면 EditText에 입력한 문자열을 ListView에 추가
        btnLv.setOnClickListener {
            list.add(et.text.toString())
            et.setText("")
            // listview에 adapter 연결
            lv.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        }

        //list에 있는 단어 누르면 삭제하는 기능
        lv.setOnItemClickListener { parent, view, position, id ->
            list.removeAt(position)
            lv.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
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