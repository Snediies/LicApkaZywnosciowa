package com.example.foodappnexttest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class User_Information_Activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_information)


        val waga = findViewById<EditText>(R.id.waga)
        val wzrost = findViewById<EditText>(R.id.wzorst)
        val btnBMI = findViewById<Button>(R.id.btnBMI)
        val rezultat = findViewById<TextView>(R.id.rezultat)

        btnBMI.setOnClickListener {
            val wagaLicz = waga.text.toString().toDoubleOrNull()
            val wzrostLicz = wzrost.text.toString().toDoubleOrNull()

            if ((wagaLicz != null) && (wzrostLicz != null) && (wzrostLicz > 0)) {
                val bmi =
                    wagaLicz / (wzrostLicz * wzrostLicz)                  //Obliczenia funkcji BMI

                val rezultatBMI = when {
                    bmi < 18.5 -> "Bmi ciała jest zbyt niskie"
                    bmi in 18.5..24.9 -> "BMI poprawne"
                    else -> "BMI zbyt wysokie"
                }
                rezultat.text = "TwojeBMI: %.2f\n$rezultatBMI".format(bmi)
            }else{
                rezultat.text = "Wprowadz prawidlowa wage, bądź wzrost"
            }
    }
    }
}