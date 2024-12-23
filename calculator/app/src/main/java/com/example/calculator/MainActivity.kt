package com.example.calculator

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etFirstNum: EditText
    private lateinit var etSecondNum: EditText
    private lateinit var txtResult: TextView
    private lateinit var btAdd: Button
    private lateinit var btSubtract: Button
    private lateinit var btMultiply: Button
    private lateinit var btDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btAdd = findViewById(R.id.btAdd)
        btSubtract = findViewById(R.id.btSubtract)
        btMultiply = findViewById(R.id.btMultiply)
        btDivide = findViewById(R.id.btDivide)
        txtResult = findViewById(R.id.txtResult)

        etFirstNum = findViewById(R.id.etFirstNum)
        etSecondNum = findViewById(R.id.etSecondNum)


        btAdd.setOnClickListener(this)
        btSubtract.setOnClickListener(this)
        btMultiply.setOnClickListener(this)
        btDivide.setOnClickListener(this)
        }

    override fun onClick(v: View?) {

        if (TextUtils.isEmpty(etFirstNum.text.toString()) || TextUtils.isEmpty(etSecondNum.text.toString())) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
        }

        else {
            val num1 = etFirstNum.text.toString().toDouble()
            val num2 = etSecondNum.text.toString().toDouble()

            if (v != null) {
                when (v.id) {
                    R.id.btAdd -> {
                        val resA = num1 + num2
                        txtResult.text = resA.toString()
                    }

                    R.id.btSubtract -> {
                        val resS = num1 - num2
                        txtResult.text = resS.toString()
                    }

                    R.id.btMultiply -> {
                        val resM = num1 * num2
                        txtResult.text = resM.toString()
                    }

                    R.id.btDivide -> {
                        if (num2 == 0.0) {
                            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        } else {
                            val resD = num1 / num2
                            txtResult.text = resD.toString()
                        }
                    }
                }
            }
        }
    }
}

