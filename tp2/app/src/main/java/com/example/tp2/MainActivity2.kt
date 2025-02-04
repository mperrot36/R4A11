package com.example.tp2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textView = findViewById<TextView>(R.id.textView3)
        val texteRecu = intent.getStringExtra("Bonjour"+"TEXT_SAISI")
        textView.text = texteRecu
    }
}