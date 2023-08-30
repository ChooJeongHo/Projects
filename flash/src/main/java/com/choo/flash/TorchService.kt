package com.choo.flash

import android.app.Service
import android.content.Intent
import android.os.IBinder

// TorchService 서비스가 Torch 클래스를 사용해야 한다.
class TorchService : Service() {
    private val torch : Torch by lazy {
        Torch(this)
    }
    // 플래시가 on / off 인지를 알기 위해서 변수 선언
    // isRunning값에 따라 on / off의 동작이 결정
    // 위젯에서 서비스가 실행될 때 액션값이 설정되지 않기 때문에 off가 실행
    private var isRunning = false

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            // 엡에서 실행할 경우
            "on" -> {
                torch.flashOn()
                isRunning = true
            }
            "off" -> {
                torch.flashOff()
                isRunning = false
            }
            // 서비스에서 실행 되었을 때
            else -> {
                isRunning = !isRunning
                if (isRunning) {
                    torch.flashOn()
                } else {
                    torch.flashOff()
                }
            }
        }
        // onStartCommand()는 매개변수 세개중 하나를 반환하다.
        // 반환하는 값에 따라 시스템이 강제로 종료후 다시 서비스를 시작할 때 어떻게 할지 결정한다.
        // START_STICKY : Null Intent로 서비스를 재시작한다. 명령을 실행하지 않지만 무기한으로 실행 중이며 작업을 기다린다.
        // START_NOT_STICKY : 다시 시작하지 않음
        // START_REDELIVER_INTENT : 마지막 Intent로 다시 시작한다. 파일 다운로드와 같은 서비스
        return super.onStartCommand(intent, flags, startId) // 내부적으로 START_STICKY를 반환한다.
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}