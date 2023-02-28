package com.example.mathgameassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addition)
        val subButton = findViewById<Button>(R.id.subtraction)
        val mulButton = findViewById<Button>(R.id.multiplication)

        addButton.setOnClickListener {
            intent = Intent(applicationContext, AdditionActivity::class.java)
            startActivity(intent)
        }
        subButton.setOnClickListener {
            intent = Intent(applicationContext, SubtractionActivity::class.java)
            startActivity(intent)
        }
        mulButton.setOnClickListener {
            intent = Intent(applicationContext, MultiplicationActivity::class.java)
            startActivity(intent)
        }
    }
}