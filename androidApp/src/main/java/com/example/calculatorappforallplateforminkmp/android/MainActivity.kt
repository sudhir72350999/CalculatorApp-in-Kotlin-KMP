package com.example.calculatorappforallplateforminkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatorappforallplateforminkmp.Greeting


import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.calculatorappforallplateforminkmp.Calculator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }

            CalculatorApp()
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
        CalculatorApp()
    }
}


@Composable
fun CalculatorApp() {
    var inputA by remember { mutableStateOf("") }
    var inputB by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val calculator = Calculator()

    Column {
        TextField(value = inputA, onValueChange = { inputA = it }, label = { Text("Input A") })
        TextField(value = inputB, onValueChange = { inputB = it }, label = { Text("Input B") })
        Row {
            Button(onClick = { result = calculator.add(inputA.toDouble(), inputB.toDouble()).toString() }) { Text("+") }
            Button(onClick = { result = calculator.subtract(inputA.toDouble(), inputB.toDouble()).toString() }) { Text("-") }
            Button(onClick = { result = calculator.multiply(inputA.toDouble(), inputB.toDouble()).toString() }) { Text("*") }
            Button(onClick = { result = calculator.divide(inputA.toDouble(), inputB.toDouble()).toString() }) { Text("/") }
        }
        Text("Result: $result")
    }
}
