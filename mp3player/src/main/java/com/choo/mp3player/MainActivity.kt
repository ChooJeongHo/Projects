package com.choo.mp3player

import android.media.MediaPlayer
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.RadioButton
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var song1: RadioButton
    lateinit var song2: RadioButton
    lateinit var song3: RadioButton
    lateinit var play: Button
    lateinit var stop: Button
    lateinit var mPlayer: MediaPlayer
    lateinit var pbMP3: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        song1 = findViewById(R.id.song1)
        song2 = findViewById(R.id.song2)
        song3 = findViewById(R.id.song3)
        play = findViewById(R.id.play)
        stop = findViewById(R.id.stop)
        pbMP3 = findViewById(R.id.pbMP3)

        play.setOnClickListener {
            if (song1.isChecked == true) {
                mPlayer = MediaPlayer.create(applicationContext, R.raw.song1)
                mPlayer.start()
                makeThread()
            } else if (song2.isChecked == true) {
                mPlayer = MediaPlayer.create(applicationContext, R.raw.song2)
                mPlayer.start()
                makeThread()
            } else if (song3.isChecked == true) {
                mPlayer = MediaPlayer.create(applicationContext, R.raw.song3)
                mPlayer.start()
                makeThread()
            } else {
                mPlayer.stop()
            }
        }

        stop.setOnClickListener {
            mPlayer.stop()
        }

        pbMP3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar, p1: Int, p2: Boolean) {
                if (p2 == true) {
                    mPlayer.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar) {

            }

            override fun onStopTrackingTouch(p0: SeekBar) {

            }
        })
    }

    fun makeThread() {
        object : Thread() {
            override fun run() {
                // 음악이 실행중이면
                while (mPlayer.isPlaying) {
                    pbMP3.max = mPlayer.duration    // 음악 파일의 최대 시간
                    pbMP3.progress == mPlayer.currentPosition   // 현재 위치를 나태낸다
                    SystemClock.sleep(100)
                }
                pbMP3.progress = 0
            }
        }.start()
    }
}