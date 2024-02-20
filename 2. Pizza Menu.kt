package com.example.selflearning

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
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.selflearning.ui.theme.SelfLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelfLearningTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Display the pizza order screen
                    PizzaOrderScreen()
                }
            }
        }
    }
}

@Composable
fun PizzaOrderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // State for tracking whether pepperoni checkbox is checked
        val pepperoniChecked = remember { mutableStateOf(false) }
        // State for tracking whether extra cheese checkbox is checked
        val extraCheeseChecked = remember { mutableStateOf(false) }

        // Checkbox for selecting pepperoni topping
        Checkbox(
            checked = pepperoniChecked.value,
            onCheckedChange = { pepperoniChecked.value = it },
            modifier = Modifier.padding(bottom = 8.dp)
        )
            Text("Pepperoni")


        // Checkbox for selecting extra cheese topping
        Checkbox(
            checked = extraCheeseChecked.value,
            onCheckedChange = { extraCheeseChecked.value = it },
            modifier = Modifier.padding(bottom = 8.dp)
        )
            Text("Extra Cheese")


        // Determine the text to display on the button based on the selected toppings
        val orderButtonText = if (pepperoniChecked.value || extraCheeseChecked.value) {
            "Place Order"
        } else {
            "Place Order"
        }

        // Button for placing the pizza order
        Button(
            onClick = {
                // Handle order placement here
                val order = StringBuilder()
                if (pepperoniChecked.value) {
                    order.append("Pepperoni")
                }
                if (extraCheeseChecked.value) {
                    if (order.isNotEmpty()) {
                        order.append(" and Extra Cheese")
                    } else {
                        order.append("Extra Cheese")
                    }
                }
                if (order.isEmpty()) {
                    order.append("Plain")
                }
                // Show order in a dialog or wherever you want
                // You can also use a Snackbar or Toast to show the order
                // For simplicity, I'm just printing it here
                println("Your pizza order: ${order.toString()}")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            // Display the button text determined earlier
            Text(text = orderButtonText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaOrderPreview() {
    SelfLearningTheme {
        // Preview the pizza order screen
        PizzaOrderScreen()
    }
}
