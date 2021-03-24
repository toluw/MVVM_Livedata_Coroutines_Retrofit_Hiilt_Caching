package com.up.cleanarchitecture.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.up.cleanarchitecture.data.model.Results

@Dao
interface CharacterDao {

    @Insert
    suspend fun insertResult(result: List<Results>)

    @Query("DELETE FROM results")
    suspend fun deleteResult()

    @Query("SELECT * FROM results")
    fun getResult(): List<Results>
}