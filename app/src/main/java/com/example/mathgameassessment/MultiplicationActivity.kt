package com.example.mathgameassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MultiplicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplication)

        val mulquestionBox = findViewById<TextView>(R.id.mulQuestion)
        val mulanswerBox = findViewById<EditText>(R.id.mulAnswerBox)
        val mulcheckAnswer = findViewById<Button>(R.id.mulCheckAnswer)
        val mulnextQuestion = findViewById<Button>(R.id.mulNextQuestion)
        val mulscore = findViewById<TextView>(R.id.mulScore)
        val mullife = findViewById<TextView>(R.id.mulLife)
        var scoreIncrement = 0
        var maxLife = 4
//        life.text = "Life :  $maxLife"
//        val nota = findViewById<TextView>(R.id.textView4)

        var number1 = numberGenerator()
        var number2= numberGenerator()

        mulquestionBox.text = "$number1 X $number2"
        mulcheckAnswer.setOnClickListener {
            if((number1*number2) == (mulanswerBox.text.toString()).toInt()){
//                nota.text = (nota.text.toString()).toInt().plus(10).toString()
                scoreIncrement += 10
                mulscore.text = "Score :  ${scoreIncrement}"
                mulquestionBox.text = "That's correct answer..."
                Toast.makeText(applicationContext, "Correct Answer", Toast.LENGTH_SHORT).show()

            }else{
                mullife.text = "Life :  ${maxLife--}"
                Toast.makeText(applicationContext, "Wrong Answer", Toast.LENGTH_SHORT).show()

                if(maxLife == -1){
                    intent = Intent(applicationContext, FinalScreen::class.java)
                    intent.putExtra("score", scoreIncrement)
                    Toast.makeText(applicationContext, "Score: $scoreIncrement", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }
        }
        mulnextQuestion.setOnClickListener {
//            questionBox.text = "${numberGenerator()} + ${numberGenerator()}"
            number1 = numberGenerator()
            number2= numberGenerator()
            mulquestionBox.text = "$number1 X $number2"
            mulanswerBox.text.clear()
        }
    }
}