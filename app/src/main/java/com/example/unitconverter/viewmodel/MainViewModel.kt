package com.example.unitconverter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.unitconverter.model.Conversion

class MainViewModel : ViewModel() {
    val conversions = listOf<Conversion>(
        Conversion("kg to lbs", "kg", "lbs", 2.20462262f),
        Conversion("lbs to kg", "lbs", "kg", 0.45359237f)
    )
}