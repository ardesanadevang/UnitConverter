package com.example.unitconverter.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitconverter.data.model.Conversion
import com.example.unitconverter.data.model.ConversionResult
import com.example.unitconverter.domain.repository.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ConverterRepository) : ViewModel() {
    val conversions = listOf<Conversion>(
        Conversion("kg to lbs", "kg", "lbs", 2.20462262f),
        Conversion("lbs to kg", "lbs", "kg", 0.45359237f)
    )

    val conversationResults = repository.fetchAllConversionResult()

    fun saveConversionResult(message1: String, message2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertConversionResult(ConversionResult(0, message1, message2))
        }
    }

    fun deleteConversionResult(conversionResult: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteConversionResult(conversionResult)
        }
    }

    fun deleteAllConversionResult() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllConversionResult()
        }
    }

}