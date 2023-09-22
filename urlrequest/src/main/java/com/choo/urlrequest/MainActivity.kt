package com.choo.urlrequest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choo.urlrequest.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonRequest.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    var urlText = binding.editUrl.text.toString()
                    if (!urlText.startsWith("https")) {
                        urlText = "https://${urlText}"
                    }
                    val url = URL(urlText)
                    val urlConnection = url.openConnection() as HttpURLConnection
                    urlConnection.requestMethod = "GET"
                    if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                        val streamReader = InputStreamReader(urlConnection.inputStream)
                        val buffered = BufferedReader(streamReader)

                        val content = StringBuilder()
                        while (true) {
                            val line = buffered.readLine() ?: break
                            content.append(line)
                        }
                        buffered.close()
                        urlConnection.disconnect()
                        launch(Dispatchers.Main) {
                            binding.textContent.text = content.toString()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
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