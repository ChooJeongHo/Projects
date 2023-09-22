package com.choo.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {          //자식 : 부모(상속)->생성자(메소드)
    lateinit var edit1: EditText;
    lateinit var edit2: EditText
    lateinit var btnPlus: Button;
    lateinit var btnMinus: Button
    lateinit var btnMul: Button;
    lateinit var btnDiv: Button
    lateinit var textResult: TextView

    lateinit var num1: String;
    lateinit var num2: String
    var result: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "처음 만들어보는 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnPlus = findViewById<Button>(R.id.btnPlus)
        btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMul = findViewById<Button>(R.id.btnMul)
        btnDiv = findViewById<Button>(R.id.btnDiv)

        textResult = findViewById<TextView>(R.id.result)

        btnPlus.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnMinus.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnMul.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
        }

        btnDiv.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()

            result = Integer.parseInt(num1) / Integer.parseInt(num2)
            textResult.text = "계산 결과 : " + result.toString()
            false
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