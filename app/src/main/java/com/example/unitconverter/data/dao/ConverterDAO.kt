package com.example.unitconverter.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.unitconverter.data.model.ConversionResult
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDAO {
    @Insert
    suspend fun insert(conversionResult: ConversionResult)

    @Delete
    suspend fun delete(conversionResult: ConversionResult)

    @Query("Delete from conversationTable")
    suspend fun deleteAll()

    @Query("Select * from conversationTable ORDER BY id DESC")
    fun fetchAll(): Flow<List<ConversionResult>>
}