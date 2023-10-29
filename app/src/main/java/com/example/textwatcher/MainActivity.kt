package com.example.textwatcher

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var numberInput: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberInput = findViewById(R.id.numberInput)
        resultText = findViewById(R.id.resultText)
    }

    fun checkPrime(view: View) {
        val inputText = numberInput.text.toString()
        if (inputText.isEmpty()) {
            resultText.text = "Жду ввода данных."
            return
        }

        val number = inputText.toInt()
        val isPrime = isPrimeNumber(number)

        if (isPrime) {
            resultText.text = "$number является простым числом."
        } else {
            resultText.text = "$number не является простым числом."
        }
    }

    private fun isPrimeNumber(n: Int): Boolean {
        if (n <= 1) {
            return false
        }
        if (n <= 3) {
            return true
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false
        }
        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false
            }
            i += 6
        }
        return true
    }
}
