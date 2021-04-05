package com.up.cleanarchitecture.di

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.up.cleanarchitecture.data.local.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Named("test_db")
    @Provides
    fun provideInMemorydb(@ApplicationContext context: Context): CharacterDatabase{
       val database = Room.inMemoryDatabaseBuilder(
            context,
            CharacterDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        return database

    }

}