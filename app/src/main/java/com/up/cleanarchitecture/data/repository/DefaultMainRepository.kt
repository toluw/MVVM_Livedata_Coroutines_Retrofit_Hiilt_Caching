package com.up.cleanarchitecture.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.up.cleanarchitecture.data.local.CharacterDao
import com.up.cleanarchitecture.data.model.Characters
import com.up.cleanarchitecture.data.model.Results
import com.up.cleanarchitecture.data.remote.CharacterApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class DefaultMainRepository
constructor(private val characterDao: CharacterDao,
            private val characterApi: CharacterApi): MainRepository {

    override fun getResults(): LiveData<List<Results>>  =
            liveData(Dispatchers.IO){
                try {
                    val characters: Characters = characterApi.get()
                    val results: List<Results> = characters.results
                    addToDb(results)
                    emit(results)

                }catch (e: Exception){
                    val results: List<Results> = characterDao.getResult()
                    emit(results)
                }
            }

    suspend fun addToDb(results: List<Results>){
        GlobalScope.launch(Dispatchers.IO) {
            characterDao.deleteResult()
            characterDao.insertResult(results) }

    }
}