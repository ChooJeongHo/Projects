package com.koreait.sample0401ex01

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.choo.buttons.R

class MainActivity : AppCompatActivity() {
    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var chkAgree: CheckBox
    lateinit var rGroup1: RadioGroup
    lateinit var rdoCat: RadioButton
    lateinit var rdoDog: RadioButton
    lateinit var rdoRabbit: RadioButton
    lateinit var imgPet: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.text1)
        chkAgree = findViewById(R.id.chkAgree)

        text2 = findViewById(R.id.text2)
        rGroup1 = findViewById(R.id.Rgroup1)
        rdoCat = findViewById(R.id.RdoCat)
        rdoDog = findViewById(R.id.RdoDog)
        rdoRabbit = findViewById(R.id.RdoRabbit)

        imgPet = findViewById(R.id.ImgPet)

        // 체크박스를 체크하면 변경함
        chkAgree.setOnCheckedChangeListener { compoundButton, b ->
            if (chkAgree.isChecked == true) {
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE
            } else {
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
            }
        }

        // 라디오 버튼은 선택 하면 이미지 출력
        rGroup1.setOnCheckedChangeListener { radioGroup, i ->
            when (rGroup1.checkedRadioButtonId) {
                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
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