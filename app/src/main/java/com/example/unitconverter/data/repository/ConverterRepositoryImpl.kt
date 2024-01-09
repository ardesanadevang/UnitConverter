package com.example.unitconverter.data.repository

import com.example.unitconverter.data.dao.ConverterDAO
import com.example.unitconverter.data.model.ConversionResult
import com.example.unitconverter.domain.repository.ConverterRepository
import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao: ConverterDAO) : ConverterRepository {
    override suspend fun insertConversionResult(conversionResult: ConversionResult) {
        dao.insert(conversionResult)
    }

    override suspend fun deleteConversionResult(conversionResult: ConversionResult) {
        dao.delete(conversionResult)
    }

    override suspend fun deleteAllConversionResult() {
        dao.deleteAll()
    }

    override fun fetchAllConversionResult(): Flow<List<ConversionResult>> {
        return dao.fetchAll();
    }
}