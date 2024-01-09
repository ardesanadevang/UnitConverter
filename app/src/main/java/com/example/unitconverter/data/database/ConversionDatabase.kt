package com.example.unitconverter.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unitconverter.data.dao.ConverterDAO
import com.example.unitconverter.data.model.ConversionResult

@Database(entities = [ConversionResult::class], version = 1)
abstract class ConversionDatabase : RoomDatabase() {
    abstract val converterDAO: ConverterDAO
}