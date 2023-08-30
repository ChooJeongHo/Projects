package com.choo.popularvote

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    lateinit var tv: Array<TextView?>
    lateinit var rbar: Array<RatingBar?>
    lateinit var tvID: Array<Int>
    lateinit var rbarID: Array<Int>
    lateinit var voteResult: IntArray
    lateinit var imageName: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        makeThread()

        tvID = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9)

        rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }

    }

    fun makeThread() {
        object : Thread() {
            override fun run() {
                val intent = intent
                voteResult = intent.getIntArrayExtra("VoteCount")!!
                imageName = intent.getStringArrayExtra("ImageName")!!
                tv = arrayOfNulls<TextView>(imageName.size)
                rbar = arrayOfNulls<RatingBar>(imageName.size)

                for (i in 0..tv.size) {
                    for (i in voteResult.indices) {
                        tv[i] = findViewById<TextView>(tvID[i])
                        rbar[i] = findViewById<RatingBar>(rbarID[i])
                        tv.indices.forEach {
                            tv[i]!!.setText(imageName[i])
                            rbar[i]!!.setRating(voteResult[i].toFloat())
                        }
                    }
                    SystemClock.sleep(3000)
                }
            }
        }.start()
    }
}