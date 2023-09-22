package com.choo.tabhost

import android.app.TabActivity
import android.os.Bundle

class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost

        var tabSpec1 = tabHost.newTabSpec("TAG1").setIndicator("강아지")
        tabSpec1.setContent(R.id.imgDog)
        tabHost.addTab(tabSpec1)

        var tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("고양이")
        tabSpec2.setContent(R.id.imgCat)
        tabHost.addTab(tabSpec2)

        var tabSpec3 = tabHost.newTabSpec("TAG3").setIndicator("토끼")
        tabSpec3.setContent(R.id.imgRabbit)
        tabHost.addTab(tabSpec3)

        tabHost.currentTab = 0
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