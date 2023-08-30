package com.choo.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var ivBattery : ImageView
    lateinit var edtBattery : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivBattery = findViewById(R.id.ivBattery)
        edtBattery = findViewById(R.id.edtBattery)
    }

    var br : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, intent: Intent?) {
            var action = intent?.action
            if(action == Intent.ACTION_BATTERY_CHANGED) {
                // EXTRA_LEVEL => 배터리의 잔량을 표시
                // EXTRA_PRESENT => 배터리의 존재 여부
                // EXTRA_PLUGGED => 외부 전원 연결 상태 표시
                // EXTRA_STATUS => 배터리 상태 표시
                var remain = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                edtBattery.setText("현재 충전량 : $remain\n")

                if (remain != null) {
                    if(remain >= 90)
                        ivBattery.setImageResource(R.drawable.battery_100)
                    else if(remain >= 70)
                        ivBattery.setImageResource(R.drawable.battery_80)
                    else if(remain >= 50)
                        ivBattery.setImageResource(R.drawable.battery_60)
                    else if(remain >= 10)
                        ivBattery.setImageResource(R.drawable.battery_20)
                    else
                        ivBattery.setImageResource(R.drawable.battery_0)
                }
            }
            var plug = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)
            when(plug) {
                0 -> edtBattery.append("전원 연결 : 안됨")
                BatteryManager.BATTERY_PLUGGED_AC -> edtBattery.append("전원 연결 : 어댑터 연결됨")
                BatteryManager.BATTERY_PLUGGED_USB -> edtBattery.append("전원 연결 : USB 연결됨")
            }
        }

    }

    // 브로드 캐스트 리시버 해제
    override fun onPause() {
        super.onPause()
        unregisterReceiver(br)
    }

    // 브로드 캐스트 리시버 등록
    override fun onResume() {
        super.onResume()
        var iFilter = IntentFilter()
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(br, iFilter)
    }
}