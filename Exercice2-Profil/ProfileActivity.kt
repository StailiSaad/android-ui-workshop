package com.example.profil

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var etNom: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        etNom = findViewById(R.id.etNom)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        btnSave = findViewById(R.id.btnSave)


        etNom.setText(tvName.text.toString())
        etEmail.setText(tvEmail.text.toString())


        btnSave.setOnClickListener {
            enregistrerProfil()
        }
    }

    private fun enregistrerProfil() {
        val nom = etNom.text.toString()
        val email = etEmail.text.toString()
        val telephone = etPhone.text.toString()

        if (nom.isEmpty()) {
            Toast.makeText(this, "Le nom est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }
        if (email.isEmpty()) {
            Toast.makeText(this, "L'email est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }
        if (telephone.isEmpty()) {
            Toast.makeText(this, "Le téléphone est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }

        tvName.text = nom
        tvEmail.text = email
        Toast.makeText(this, "Profil enregistré avec succès!", Toast.LENGTH_LONG).show()
    }
}
