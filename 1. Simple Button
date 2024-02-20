package com.example.selflearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column // Importing Column layout composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button // Importing Button composable from Material3 library
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.selflearning.ui.theme.SelfLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelfLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column { // Column layout to vertically stack composables
                        Greeting("Android") // Display greeting text
                        ClickableButton() // Display clickable button
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ClickableButton() {
    Button(onClick = { /* Your click logic goes here */ }) { // Button composable with onClick listener
        Text("Click Me") // Text displayed on the button
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SelfLearningTheme {
        Column { // Column layout for preview
            Greeting("Android")
            ClickableButton()
        }
    }
}
