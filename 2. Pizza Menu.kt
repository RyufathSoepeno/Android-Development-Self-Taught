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
    // State for tracking whether pepperoni checkbox is checked
    val pepperoniChecked = remember { mutableStateOf(false) }
    // State for tracking whether extra cheese checkbox is checked
    val extraCheeseChecked = remember { mutableStateOf(false) }

    // State for holding the order text
    val orderText = remember { mutableStateOf("") }

    // Text for pepperoni option
    Text("    Pepperoni")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Checkbox for selecting pepperoni topping
        Checkbox(
            checked = pepperoniChecked.value,
            onCheckedChange = { pepperoniChecked.value = it },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Text for extra cheese option
        Text("Extra Cheese")

        // Checkbox for selecting extra cheese topping
        Checkbox(
            checked = extraCheeseChecked.value,
            onCheckedChange = { extraCheeseChecked.value = it },
            modifier = Modifier.padding(bottom = 8.dp)
        )


        // Button for placing the pizza order
        Button(
            onClick = {
                // Handle order placement here
                val orderBuilder = StringBuilder()
                if (pepperoniChecked.value) {
                    orderBuilder.append("Pepperoni")
                }
                if (extraCheeseChecked.value) {
                    if (orderBuilder.isNotEmpty()) {
                        orderBuilder.append(" and Extra Cheese")
                    } else {
                        orderBuilder.append("Extra Cheese")
                    }
                }
                if (orderBuilder.isEmpty()) {
                    orderBuilder.append("Plain")
                }

                // Update the order text state variable
                orderText.value = orderBuilder.toString()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            // Display the button text based on the order status
            Text(text = "Place Order")
        }

        // Display the order text
        if (orderText.value.isNotEmpty()) {
            Text(text = "Your order: ${orderText.value}")
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
