package com.choo.flash

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager

class Torch(context: Context) {
    private var cameraId: String? = null    // 카메라를 on / off 할 때
    private var cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    init {
        cameraId = getCameraId()
    }

    fun flashOn() {
        cameraId?.let {
            cameraManager.setTorchMode(it, true)
        }
    }

    fun flashOff() {
        cameraId?.let {
            cameraManager.setTorchMode(it, false)
        }
    }

    private fun getCameraId(): String? {
        val cameraIds = cameraManager.cameraIdList
        for (id in cameraIds) {
            val info = cameraManager.getCameraCharacteristics(id)   // 각 ID별로 세부 정보를 가지는 객체를 넘긴다.
            // 플래시 기능 여부 확인
            val flashAvailable = info.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)
            // 카메라 렌즈 정보
            val lensFacing = info.get(CameraCharacteristics.LENS_FACING)
            // 플래시 가능하고 카메라의 종류 및 현재 뒷면을 향하고 있다라는 정보를 반환
            if (flashAvailable != null && flashAvailable && lensFacing != null && lensFacing == CameraCharacteristics.LENS_FACING_BACK) {
                return id // 모든 카메라에 관한 정보를 반환
            }
        }
        return null // 카메라 id를 찾지 못했다면
    }
}