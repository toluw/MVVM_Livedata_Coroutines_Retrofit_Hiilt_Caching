package com.up.cleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.up.cleanarchitecture.data.model.Results

@Database(entities = [Results::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao() : CharacterDao

    companion object{
        val DATABASE_NAME = "character_db"
    }
}