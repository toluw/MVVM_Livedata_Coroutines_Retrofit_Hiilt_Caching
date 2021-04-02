package com.up.cleanarchitecture.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.up.cleanarchitecture.Others.Constants
import com.up.cleanarchitecture.data.remote.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder() : Gson{
        return GsonBuilder()
               .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideCharacterApi(retrofit: Retrofit.Builder): CharacterApi{
        return retrofit
            .build()
            .create(CharacterApi::class.java)
    }

}