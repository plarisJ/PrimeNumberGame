package com.example.primenumbergame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        var intentData = intent.extras
        var playerName = intentData?.getString("PlayerName")
        //Toast.makeText(this, "Welcome $playerName", Toast.LENGTH_LONG).show()
        sayHi.text ="Welcome $playerName"
        var primeNoList: MutableList<Int> = mutableListOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
        var ans= false
        var rnds= randomFun()
        var point=0

        btnYes.setOnClickListener {
            ans = if (primeNoList.contains(rnds)){
                Toast.makeText(this, "Correct $rnds is Prime Number", Toast.LENGTH_SHORT).show()
                rnds=randomFun()
                point+=1
                true
            }else{
                Toast.makeText(this, "Not Correct $rnds is Not Prime Number", Toast.LENGTH_SHORT).show()
                stopFun(point,playerName.toString())
                false
            }
        }
        btnNo.setOnClickListener {
            ans = if (primeNoList.contains(rnds)){
                Toast.makeText(this, "Not Correct  $rnds is Prime Number", Toast.LENGTH_SHORT).show()
                stopFun(point,playerName.toString())
                false
            }else{
                Toast.makeText(this, "Correct $rnds is Not Prime Number", Toast.LENGTH_SHORT).show()
                rnds=randomFun()
                point+=1
                true
            }
        }

    }
     fun randomFun(): Int {
         val rnds = (0..100).random()
         ramdomNum.text = rnds.toString()
         return rnds
    }
    @SuppressLint("SetTextI18n")
    fun stopFun(point:Int,playerName:String) {
        val scoreActivityIntent = Intent(this,ScoreActivity::class.java)
        scoreActivityIntent.putExtra("point",point)
        scoreActivityIntent.putExtra("playerName",playerName)
        startActivity(scoreActivityIntent)
    }
}