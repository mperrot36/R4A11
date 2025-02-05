package com.example.tp2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textView = findViewById<TextView>(R.id.textView3)

        val texteRecu = intent.getStringExtra("TEXT_SAISI")
        val ageCalcul = intent.getIntExtra("AGE_CALCUL", 0)  // Valeur par défaut = 0 si l'age n'est pas trouvé

        textView.text = "Hello $texteRecu vous avez $ageCalcul ans !"


    }
}