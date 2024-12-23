package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {


    private var days = arrayOf(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )

    private lateinit var day: String;
    private lateinit var random: Random;

    private lateinit var txtCorrectAnswer: TextView;
    private lateinit var txtQuestionContainer: TextView;
    private lateinit var txtRightAnswer: TextView;
    private lateinit var txtUserInput: EditText;
    private lateinit var btShow: Button;
    private lateinit var btCheck: Button;
    private lateinit var btNext: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtQuestionContainer=findViewById(R.id.txtQuestionContainer);
        txtRightAnswer=findViewById(R.id.txtRightAnswer);
        txtCorrectAnswer=findViewById(R.id.txtCorrectAnswer);

        txtUserInput=findViewById(R.id.eUserInput);

        btShow=findViewById(R.id.btShow);
        btCheck=findViewById(R.id.btCheck);
        btNext=findViewById(R.id.btNext);


        random = Random();


        day = days[random.nextInt(days.size)];


        fun mixWords(word: String): String {
            val charList = word.toList()
            val shuffledList = charList.shuffled()
            return shuffledList.joinToString("")
        }

        txtQuestionContainer.text = mixWords(day);



        btCheck.setOnClickListener {
            if (txtUserInput.text.toString().equals(day, ignoreCase = true)) {
                var dialog= Dialog(this@MainActivity)
                dialog.setContentView(R.layout.correct_dialog)
                var bthide=dialog.findViewById<Button>(R.id.btConfirmDialog)
                dialog.show()

                bthide.setOnClickListener {
                    dialog.dismiss()

                    day = days[random.nextInt(days.size)];
                    txtQuestionContainer.text = mixWords(day)
                    txtUserInput.setText("")
                    txtCorrectAnswer.visibility= View.INVISIBLE;
                    txtRightAnswer.visibility= View.INVISIBLE;
                }

            } else {
                Toast.makeText(this@MainActivity, "Wrong", Toast.LENGTH_SHORT).show()
            }
        }

        btShow.setOnClickListener {

            txtCorrectAnswer.visibility= View.VISIBLE;
            txtRightAnswer.visibility= View.VISIBLE;
            txtCorrectAnswer.text=day;
        }
        btNext.setOnClickListener {

            day = days[random.nextInt(days.size)];
            txtQuestionContainer.text = mixWords(day)
            txtUserInput.setText("")
            txtCorrectAnswer.visibility= View.INVISIBLE;
            txtRightAnswer.visibility= View.INVISIBLE;
        }

    }
}


