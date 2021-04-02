package com.up.cleanarchitecture.data.repository

import androidx.lifecycle.LiveData
import com.up.cleanarchitecture.data.local.CharacterDao
import com.up.cleanarchitecture.data.model.Results
import com.up.cleanarchitecture.data.remote.CharacterApi
import javax.inject.Inject

interface MainRepository {

    fun getResults(): LiveData<List<Results>>
}