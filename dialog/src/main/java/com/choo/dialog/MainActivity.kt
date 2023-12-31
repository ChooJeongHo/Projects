package com.choo.dialog

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var button : Button
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        rdoDog = findViewById(R.id.rdoDog)
        rdoCat = findViewById(R.id.rdoCat)
        rdoRabbit = findViewById(R.id.rdoRabbit)

        button.setOnClickListener {
            // 버튼을 클릭하면 실행할 코드 (대화상자 : 동물이름 + 동물이미지 + 닫기버튼)
            if(rdoDog.isChecked == true){
                var builder = AlertDialog.Builder(this)
                builder.setTitle("강아지")
                builder.setIcon(R.drawable.dog)
                builder.setPositiveButton("닫기", null)
                builder.show()
            } else if(rdoCat.isChecked == true){
                var builder = AlertDialog.Builder(this)
                builder.setTitle("고양이")
                builder.setIcon(R.drawable.cat)
                builder.setPositiveButton("닫기", null)
                builder.show()
            } else if(rdoRabbit.isChecked == true){
                var builder = AlertDialog.Builder(this)
                builder.setTitle("토끼")
                builder.setIcon(R.drawable.rabbit)
                builder.setPositiveButton("닫기", null)
                builder.show()
            }
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