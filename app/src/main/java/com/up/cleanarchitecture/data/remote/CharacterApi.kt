package com.up.cleanarchitecture.data.remote

import com.up.cleanarchitecture.data.model.Characters
import retrofit2.http.GET
import retrofit2.Call;

interface CharacterApi {
    @GET("character")
    suspend fun get() : Characters


}