package com.choo.flash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choo.flash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 안드로이드 6.0 이상에서 실행
        // val torch = Torch(this) // 객체(인스턴스화)
        binding.flashSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // 스위치가 on이면 flashOn() 메서드 호출하여 플래시 켜고
                // torch.flashOn()
                // startService(intentFor<TorchService>().setAction("on"))
                startService(Intent(this, TorchService::class.java).apply {
                    action = "on"
                })
            } else {
                // 스위치가 on이면 flashOff() 메서드 호출하여 플래시 끈다.
                // torch.flashOff()
                // startService(intentFor<TorchService>().setAction("Off"))
                startService(Intent(this, TorchService::class.java).apply {
                    action = "off"
                })
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