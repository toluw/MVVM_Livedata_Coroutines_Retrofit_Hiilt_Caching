package com.up.cleanarchitecture.di

import android.content.Context
import androidx.room.Room
import com.up.cleanarchitecture.data.local.CharacterDao
import com.up.cleanarchitecture.data.local.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideCharacterDatabase(@ApplicationContext context: Context) : CharacterDatabase{
        return Room.databaseBuilder(context,CharacterDatabase::class.java, CharacterDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCharacterDao(characterDatabase: CharacterDatabase): CharacterDao {
        return characterDatabase.characterDao()
    }

}