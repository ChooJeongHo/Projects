package com.choo.stopwatch

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var chronometer: Chronometer
    lateinit var btnInit: Button
    lateinit var btnStart: Button
    var pauseTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer = findViewById(R.id.chronometer)
        btnInit = findViewById(R.id.btnInit)
        btnStart = findViewById(R.id.btnStart)

        btnInit.setOnClickListener {
            pauseTime = 0L
            chronometer.base = SystemClock.elapsedRealtime()
            chronometer.stop()
        }

        // 시작 버튼 누르면 시작되고 일시정지 버튼으로 바뀜 다시 누르면 일시정지
        btnStart.setOnClickListener {
            if(btnStart.text.toString() == "시작") {
                chronometer.base = SystemClock.elapsedRealtime() + pauseTime
                chronometer.start()
                btnStart.text = "일시정지"
            } else {
                // 일시정지 버튼 누르면 현재 시간을 기준으로 시간이 멈춤
                pauseTime = chronometer.base - SystemClock.elapsedRealtime()
                chronometer.stop()
                btnStart.text = "시작"
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