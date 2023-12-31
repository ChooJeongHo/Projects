package com.choo.calllist

import android.os.Bundle
import android.provider.CallLog
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btnCall : Button
    lateinit var edtCall : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CALL_LOG), MODE_PRIVATE)

        btnCall = findViewById(R.id.btnCall)
        edtCall = findViewById(R.id.edtCall)

        btnCall.setOnClickListener {
            edtCall.setText(findCallHistory())
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

    fun findCallHistory() : String {
        var callSet = arrayOf(CallLog.Calls.DATE, CallLog.Calls.TYPE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION)
        var c = contentResolver.query(CallLog.Calls.CONTENT_URI, callSet, null, null, null)

        if(c!!.count == 0) {
            return "통화기록 없음"
        }

        var callBuff = StringBuffer()   // 최대 통화목록을 100개 ~ 110개 정도 저장할 수 있다.
        callBuff.append("\n날짜  :  구분  :  전화번호  :  통화시간\n")
        c.moveToFirst()
        do {
            var callDate = c.getLong(0) // index 0을 의미(날짜형식)
            var datePattern = SimpleDateFormat("yyyy-MM-dd")
            var date_str = datePattern.format(Date(callDate))
            callBuff.append("$date_str : ")
            if(c.getInt(1) == CallLog.Calls.INCOMING_TYPE) {
                callBuff.append("착신 : ")
            } else {
                callBuff.append("발신 : ")
            }
            callBuff.append("${c.getString(2)} : ")
            callBuff.append("${c.getString(3)}초\n")
        } while(c.moveToNext())

        c.close()
        return callBuff.toString()
    }
}