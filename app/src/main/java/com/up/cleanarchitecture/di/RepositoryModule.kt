package com.up.cleanarchitecture.di

import com.up.cleanarchitecture.data.local.CharacterDao
import com.up.cleanarchitecture.data.remote.CharacterApi
import com.up.cleanarchitecture.data.repository.DefaultMainRepository
import com.up.cleanarchitecture.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(characterDao: CharacterDao,
                              characterApi: CharacterApi):MainRepository{
        return DefaultMainRepository(characterDao,characterApi)
    }
}