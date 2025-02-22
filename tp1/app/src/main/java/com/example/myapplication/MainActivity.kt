package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        const val EXTRA_TEXT = "text_to_display"
        setContentView(R.layout.activity_main)

        val premierBouton: Button = findViewById(R.id.premierButton)
        val editText: EditText = findViewById(R.id.editText)
        val textView: TextView = findViewById(R.id.textView1)
        val layoutPrincipal: ConstraintLayout = findViewById(R.id.mainLayout)

        val deuxiemeTextView = TextView(this)

        premierBouton.setOnClickListener {

            val texte = editText.text.toString()
            textView.text = texte

            if (texte == "afficher nouveau textView") {
                if (deuxiemeTextView.parent == null) {
                    deuxiemeTextView.text = "afficher nouveau textView"
                    deuxiemeTextView.textSize = 20f
                    val layoutParams = ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                    )
                    layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                    deuxiemeTextView.layoutParams = layoutParams

                    layoutPrincipal.addView(deuxiemeTextView)
                }
            }
        }
        val boutonNext: Button = findViewById(R.id.next)
        boutonNext.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)

            intent.putExtra(EXTRA_TEXT, VOSDONNEES)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun enableEdgeToEdge() {
        TODO("Not yet implemented")
    }
}
