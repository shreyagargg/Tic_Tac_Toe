package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var flag = 0
    private var count = 0

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.title = "home"

        // Initialize buttons
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)
        btn6 = findViewById(R.id.button6)
        btn7 = findViewById(R.id.button7)
        btn8 = findViewById(R.id.button8)
        btn9 = findViewById(R.id.button9)
    }

    @SuppressLint("SetTextI18n")
    fun checkBtn(v: View) {
        if (v is Button) {
            if (v.text.toString() == "") {
                if (flag == 0) {
                    v.text = "X"
                    flag = 1
                } else {
                    v.text = "O"
                    flag = 0
                }
                count++

                if (count >= 5) {
                    val b1 = btn1.text.toString()
                    val b2 = btn2.text.toString()
                    val b3 = btn3.text.toString()
                    val b4 = btn4.text.toString()
                    val b5 = btn5.text.toString()
                    val b6 = btn6.text.toString()
                    val b7 = btn7.text.toString()
                    val b8 = btn8.text.toString()
                    val b9 = btn9.text.toString()

                    if (b1 == b2 && b2 == b3 && b1 != "") {
                        Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                        reStart()
                    } else if (b4 == b5 && b5 == b6 && b4 != "") {
                        Toast.makeText(this, "Winner is $b4", Toast.LENGTH_SHORT).show()
                        reStart()
                    } else if (b7 == b8 && b8 == b9 && b7 != "") {
                        Toast.makeText(this, "Winner is $b7", Toast.LENGTH_SHORT).show()
                        reStart()
                    } else if (b1 == b4 && b4 == b7 && b1 != "") {
                        Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                        reStart()
                    } else if (b2 == b5 && b5 == b8 && b2 != "") {
                        Toast.makeText(this, "Winner is $b2", Toast.LENGTH_SHORT).show()
                        reStart()
                    } else if (b3 == b6 && b6 == b9 && b3 != "") {
                        Toast.makeText(this, "Winner is $b3", Toast.LENGTH_SHORT).show()
                        reStart()
                    } else if (b1 == b5 && b5 == b9 && b1 != "") {
                        Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                        reStart()
                    } else if (b3 == b5 && b5 == b7 && b3 != "") {
                        Toast.makeText(this, "Winner is $b3", Toast.LENGTH_SHORT).show()
                        reStart()
                    }
                    else{
                        if(b1 != "" && b2 != "" && b3 != "" &&
                            b5 != "" && b6 != "" && b7 != "" &&
                            b8 != "" && b9 != "" && b4 != ""){
                            Toast.makeText(this,"Match draw", Toast.LENGTH_SHORT).show()
                            reStart()

                        }
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun reStart() {
        // Clear button texts
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""

        flag = 0
        count = 0
    }
}
