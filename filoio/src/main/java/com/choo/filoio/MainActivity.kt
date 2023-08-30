package com.choo.filoio

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnRead: Button = findViewById(R.id.btnRead)
        var btnWrite: Button = findViewById(R.id.btnWrite)

        btnWrite.setOnClickListener {
            var outFs: FileOutputStream = openFileOutput("test.txt", Context.MODE_PRIVATE)
            var str = "처음 만들어 보는 메모리 저장 파일"
            outFs.write(str.toByteArray())      // 문자열을 byte[]형으로 변경한다.
            outFs.close()
            Toast.makeText(applicationContext, "file이 생성되었습니다.", Toast.LENGTH_SHORT).show()
        }

        btnRead.setOnClickListener {
            try {
                var inFs = openFileInput("test.txt")
                var txt = ByteArray(40)
                inFs.read(txt)
                var str = txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
                inFs.close()
            } catch (e: IOException) {
                Toast.makeText(applicationContext, "읽을 파일 없음", Toast.LENGTH_SHORT).show()
            }
        }
    }
}