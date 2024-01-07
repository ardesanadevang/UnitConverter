package com.example.unitconverter.model

data class Conversion(
    val description: String,
    val fromUnit: String,
    val toUnit: String,
    val ratio: Float
)
