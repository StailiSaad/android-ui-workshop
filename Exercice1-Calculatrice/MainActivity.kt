package com.example.calculatricesimple

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatricesimple.R

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvResult = findViewById(R.id.tvResult)
        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)

        btnAdd.setOnClickListener { calculer("addition") }
        btnSubtract.setOnClickListener { calculer("soustraction") }
    }

    private fun calculer(operation: String) {
        val nombre1Text = etNumber1.text.toString()
        val nombre2Text = etNumber2.text.toString()

        if (nombre1Text.isEmpty() || nombre2Text.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir les deux nombres", Toast.LENGTH_SHORT).show()
            return
        }

        val nombre1 = nombre1Text.toDouble()
        val nombre2 = nombre2Text.toDouble()

        val resultat = when (operation) {
            "addition" -> nombre1 + nombre2
            "soustraction" -> nombre1 - nombre2
            else -> 0.0
        }

        tvResult.text = "Résultat : $resultat"
    }
}
