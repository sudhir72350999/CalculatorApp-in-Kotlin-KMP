package com.example.calculatorappforallplateforminkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform