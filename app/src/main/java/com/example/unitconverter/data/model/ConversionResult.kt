package com.example.unitconverter.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversationTable")
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int,
    @ColumnInfo(name = "Message1")
    val message1: String,
    @ColumnInfo(name = "Message2")
    val message2: String
)
