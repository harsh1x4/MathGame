package com.example.mathgameassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AdditionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)

        val questionBox = findViewById<TextView>(R.id.question)
        val answerBox = findViewById<EditText>(R.id.answerBox)
        val checkAnswer = findViewById<Button>(R.id.checkAnswer)
        val nextQuestion = findViewById<Button>(R.id.nextQuestion)
        val score = findViewById<TextView>(R.id.score)
        val life = findViewById<TextView>(R.id.life)
        var scoreIncrement = 0
        var maxLife = 4
//        life.text = "Life :  $maxLife"
//        val nota = findViewById<TextView>(R.id.textView4)

        var number1 = numberGenerator()
        var number2= numberGenerator()

        questionBox.text = "$number1 + $number2"
        checkAnswer.setOnClickListener {
            if((number1+number2) == (answerBox.text.toString()).toInt()){
//                nota.text = (nota.text.toString()).toInt().plus(10).toString()
                scoreIncrement += 10
                score.text = "Score :  ${scoreIncrement}"
                questionBox.text = "That's correct answer..."
                Toast.makeText(applicationContext, "Correct Answer", Toast.LENGTH_SHORT).show()

            }else{
                life.text = "Life :  ${maxLife--}"
                Toast.makeText(applicationContext, "Wrong Answer", Toast.LENGTH_SHORT).show()

                if(maxLife == -1){
                    intent = Intent(applicationContext, FinalScreen::class.java)
                    intent.putExtra("score", scoreIncrement)
                    Toast.makeText(applicationContext, "Score: $scoreIncrement", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }
        }
        nextQuestion.setOnClickListener {
//            questionBox.text = "${numberGenerator()} + ${numberGenerator()}"
            number1 = numberGenerator()
            number2= numberGenerator()
            questionBox.text = "$number1 + $number2"
            answerBox.text.clear()
        }

    }
}