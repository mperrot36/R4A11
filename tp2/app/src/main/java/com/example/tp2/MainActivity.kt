
package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.button)
        val editTextYear = findViewById<EditText>(R.id.editTextText2)
        button.setOnClickListener {
            val text = editText.text.toString().trim()
            val yearText = editTextYear.text.toString().trim()

            if (text.isNotEmpty() && yearText.isNotEmpty()) {
                val birthYear = yearText.toIntOrNull()
                if (birthYear != null) {
                    val age = AgeCalculator.calculateAge(birthYear)
                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("TEXT_SAISI", text)
                    intent.putExtra("AGE_CALCUL", age)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Veuillez rentrer une année valide", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            }
        }

        val displayText = findViewById<TextView>(R.id.textView2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                displayText.text = s
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}