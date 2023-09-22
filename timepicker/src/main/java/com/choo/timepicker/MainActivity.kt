package com.choo.timepicker

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var chrono : Chronometer
    //    lateinit var btnStart : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calView : CalendarView
    lateinit var tPicker : TimePicker
    //    lateinit var btnEnd : Button
    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMinute : TextView

    // 캘린더뷰에서 선택할 변수 선언
    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btnStart = findViewById(R.id.btnStart)
//        btnEnd = findViewById(R.id.btnEnd)

        chrono = findViewById(R.id.chronometer1)

        rdoCal = findViewById(R.id.rdoCal)
        rdoTime = findViewById(R.id.rdoTime)

        tPicker = findViewById(R.id.timePicker1)
        calView = findViewById(R.id.calendarView1)

        tvYear = findViewById(R.id.tvYear)
        tvMonth = findViewById(R.id.tvMonth)
        tvDay = findViewById(R.id.tvDay)
        tvHour = findViewById(R.id.tvHour)
        tvMinute = findViewById(R.id.tvMinute)

        rdoCal.visibility = View.INVISIBLE
        rdoTime.visibility = View.INVISIBLE
        tPicker.visibility = View.INVISIBLE
        calView.visibility = View.INVISIBLE

        // Chronometer 누르면 Radiobutton보이고 시작
        chrono.setOnClickListener {
            rdoCal.visibility = View.VISIBLE
            rdoTime.visibility = View.VISIBLE
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
        }

        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE
            calView.visibility = View.VISIBLE
        }
        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE
            calView.visibility = View.INVISIBLE
        }

        // 캘린더뷰에서 날짜 선택
        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
        }

        // 출력된 시간 누를시 Chronometer 멈추기
        tvYear.setOnClickListener {
            chrono.stop()

            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            tvHour.text = Integer.toString(tPicker.currentHour)
            tvMinute.text = Integer.toString(tPicker.currentMinute)
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