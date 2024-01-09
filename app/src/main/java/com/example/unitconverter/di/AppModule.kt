package com.example.unitconverter.di

import android.app.Application
import androidx.room.Room
import com.example.unitconverter.data.database.ConversionDatabase
import com.example.unitconverter.data.repository.ConverterRepositoryImpl
import com.example.unitconverter.domain.repository.ConverterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideConverterDatabase(application: Application): ConversionDatabase {
        return Room.databaseBuilder(
            application,
            ConversionDatabase::class.java,
            "dbName"
        ).build()
    }

    @Singleton
    @Provides
    fun provideConverterRepository(conversionDatabase: ConversionDatabase): ConverterRepository {
        return ConverterRepositoryImpl(conversionDatabase.converterDAO);
    }
}