package com.example.mathgameassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SubtractionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subtraction)

        val subquestionBox = findViewById<TextView>(R.id.subQuestion)
        val subanswerBox = findViewById<EditText>(R.id.subAnswerBox)
        val subcheckAnswer = findViewById<Button>(R.id.subCheckAnswer)
        val subnextQuestion = findViewById<Button>(R.id.subNextQuestion)
        val subscore = findViewById<TextView>(R.id.subScore)
        val sublife = findViewById<TextView>(R.id.subLife)
        var scoreIncrement = 0
        var maxLife = 4
//        life.text = "Life :  $maxLife"
//        val nota = findViewById<TextView>(R.id.textView4)

        var number1 = numberGenerator()
        var number2= numberGenerator()

        subquestionBox.text = "$number1 - $number2"
        subcheckAnswer.setOnClickListener {
            if((number1-number2) == (subanswerBox.text.toString()).toInt()){
//                nota.text = (nota.text.toString()).toInt().plus(10).toString()
                scoreIncrement += 10
                subscore.text = "Score :  ${scoreIncrement}"
                subquestionBox.text = "That's correct answer..."
                Toast.makeText(applicationContext, "Correct Answer", Toast.LENGTH_SHORT).show()

            }else{
                sublife.text = "Life :  ${maxLife--}"
                Toast.makeText(applicationContext, "Wrong Answer", Toast.LENGTH_SHORT).show()

                if(maxLife == -1){
                    intent = Intent(applicationContext, FinalScreen::class.java)
                    intent.putExtra("score", scoreIncrement)
                    Toast.makeText(applicationContext, "Score: $scoreIncrement", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }
        }
        subnextQuestion.setOnClickListener {
//            questionBox.text = "${numberGenerator()} + ${numberGenerator()}"
            number1 = numberGenerator()
            number2= numberGenerator()
            subquestionBox.text = "$number1 - $number2"
            subanswerBox.text.clear()
        }
    }
}