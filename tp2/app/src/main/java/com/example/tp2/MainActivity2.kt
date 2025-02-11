package com.example.tp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp2.ui.theme.Tp2Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val receivedName = intent.getStringExtra("USER_NAME") ?: "Nom inconnu"
        val receivedAge = intent.getStringExtra("USER_AGE") ?: "Age inconnu"
        setContent {
            Tp2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    DisplayNameScreen(receivedName,receivedAge, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DisplayNameScreen(name: String, age: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello $name vous avez $age ans",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayNameScreenPreview() {
    Tp2Theme {
        DisplayNameScreen(name = "John Doe", age="0")
    }
}
