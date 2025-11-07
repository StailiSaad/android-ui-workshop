package com.example.applicationdecontact
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAddress1: EditText
    private lateinit var etAddress2: EditText
    private lateinit var rgCategory: RadioGroup
    private lateinit var tvContactDisplay: TextView
    private lateinit var btnAdd: Button
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // Binding
        etFullName = findViewById(R.id.etFullName)
        etPhone = findViewById(R.id.etPhone)
        etEmail = findViewById(R.id.etEmail)
        etAddress1 = findViewById(R.id.etAddress1)
        etAddress2 = findViewById(R.id.etAddress2)
        rgCategory = findViewById(R.id.rgCategory)
        tvContactDisplay = findViewById(R.id.tvContactDisplay)
        btnAdd = findViewById(R.id.btnAdd)
        btnReset = findViewById(R.id.btnReset)


        btnAdd.setOnClickListener { ajouterContact() }
        btnReset.setOnClickListener { reinitialiser() }
    }

    private fun ajouterContact() {
        val nom = etFullName.text.toString()
        val telephone = etPhone.text.toString()
        val email = etEmail.text.toString()
        val adresse1 = etAddress1.text.toString()
        val adresse2 = etAddress2.text.toString()
        val selectedId = rgCategory.checkedRadioButtonId

        if (nom.isEmpty()) {
            Toast.makeText(this, "Le nom est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }
        if (telephone.isEmpty()) {
            Toast.makeText(this, "Le téléphone est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }
        if (email.isEmpty()) {
            Toast.makeText(this, "L'email est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }
        if (selectedId == -1) {
            Toast.makeText(this, "Veuillez sélectionner une catégorie", Toast.LENGTH_SHORT).show()
            return
        }

        val radioButton = findViewById<RadioButton>(selectedId)
        val category = radioButton.text.toString()

        val contactInfo = """
            📇 Contact ajouté :
            Nom : $nom
            📞 Tél : $telephone
            📧 Email : $email
            🏠 Adresse : $adresse1, $adresse2
            🏷 Catégorie : $category
        """.trimIndent()

        tvContactDisplay.text = contactInfo
        Toast.makeText(this, "Contact ajouté !", Toast.LENGTH_LONG).show()
    }

    private fun reinitialiser() {
        etFullName.setText("")
        etPhone.setText("")
        etEmail.setText("")
        etAddress1.setText("")
        etAddress2.setText("")
        rgCategory.clearCheck()
        tvContactDisplay.text = "Aucun contact ajouté"
        Toast.makeText(this, "Formulaire réinitialisé", Toast.LENGTH_SHORT).show()
    }
}
