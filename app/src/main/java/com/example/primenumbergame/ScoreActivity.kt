package com.example.primenumbergame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_play.*
import kotlinx.android.synthetic.main.activity_score.*


class ScoreActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        var intentData = intent.extras
        var score = intentData?.getInt("point")
        var playerName = intentData?.getString("playerName")
        Score.text="GAME OVER \n Your Score : $score"

        btnAgain.setOnClickListener {
            var playActivityIntent = Intent(this,PlayActivity::class.java)
            playActivityIntent.putExtra("PlayerName",playerName)
            startActivity(playActivityIntent)
        }
        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}