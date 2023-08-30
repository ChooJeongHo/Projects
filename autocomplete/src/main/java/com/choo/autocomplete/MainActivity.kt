package com.choo.autocomplete

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ArrayAdapter ==> 뷰(View)와 데이터를 연결해주는 기능
        var items = arrayOf("스파이더맨-1", "스파이더맨-2", "스파이더맨-3", "슈퍼맨-1", "슈퍼맨-2", "더글로리")
        var auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1)
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items)
        auto.setAdapter(adapter)

        var multi = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView1)
        var auto1 = MultiAutoCompleteTextView.CommaTokenizer()
        multi.setTokenizer(auto1)
        multi.setAdapter(adapter)

    }
}