package com.example.primenumbergame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnPlayOnClick(view: View) {
        val playerName = PlayerName.text.toString()
        var playActivityIntent = Intent(this,PlayActivity::class.java)
        playActivityIntent.putExtra("PlayerName",playerName)
        startActivity(playActivityIntent)
    }
}