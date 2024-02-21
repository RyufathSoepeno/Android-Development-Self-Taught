package com.example.selflearning /** Importing is very important */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
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
                    Greeting("Android")
                }
            }
        }
        // Output information to the Logcat.
        // This is bad code!
        // It attempts to access a non-existent textView causing a NullPointerException.
        val textView: String? = null
        if (textView == null) {
            android.util.Log.i("READ ME!", "textView is null")
        } else {
            android.util.Log.i("READ ME!", "‐‐>" + textView)
        }
    }

    // This is bad code!
    // It creates an infinite loop and crashes the app.
    // This function keeps calling itself recursively.
    fun badFunction() {
        badFunction()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SelfLearningTheme {
        Greeting("Android")
    }
}
