package com.example.unitconverter.domain.repository

import com.example.unitconverter.data.model.ConversionResult
import kotlinx.coroutines.flow.Flow

interface ConverterRepository {
    suspend fun insertConversionResult(conversionResult: ConversionResult)
    suspend fun deleteConversionResult(conversionResult: ConversionResult)
    suspend fun deleteAllConversionResult()
    fun fetchAllConversionResult(): Flow<List<ConversionResult>>
}