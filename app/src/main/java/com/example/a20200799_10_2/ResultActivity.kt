package com.example.a20200799_10_2

import android.R.attr.text
import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"

        val voteResult = intent.getIntArrayExtra("VoteCount") ?: return
        val imageName = intent.getStringArrayExtra("ImageName") ?: return

        val imageField = arrayOf(
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
        )

        val tvIDs = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9)
        val rbarIDs = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)

        var maxIndex = 0
        for (i in voteResult.indices) {
            if (voteResult[i] > voteResult[maxIndex]) {
                maxIndex = i
            }

            findViewById<TextView>(tvIDs[i]).text = imageName[i]
            findViewById<RatingBar>(rbarIDs[i]).rating = voteResult[i].toFloat()
        }

        val tvTop = findViewById<TextView>(R.id.tvTop)
        val ivTop = findViewById<ImageView>(R.id.ivTop)

        tvTop.text = imageName[maxIndex]
        ivTop.setImageResource(imageField[maxIndex])

        findViewById<Button>(R.id.btnReturn).setOnClickListener {
            finish()
        }

    }
}