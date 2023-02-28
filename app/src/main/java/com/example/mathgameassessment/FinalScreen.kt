package com.example.mathgameassessment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_screen)

        val finalScore = findViewById<TextView>(R.id.finalScore)
        finalScore.text = "Your Score :  ${intent.getIntExtra("score", 0)}"

        val playAgain = findViewById<Button>(R.id.playAgain)
        playAgain.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}