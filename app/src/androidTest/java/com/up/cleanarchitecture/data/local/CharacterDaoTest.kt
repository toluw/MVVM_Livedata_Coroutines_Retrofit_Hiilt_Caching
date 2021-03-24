package com.up.cleanarchitecture.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import com.up.cleanarchitecture.data.model.Results
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterDaoTest {
    private lateinit var database: CharacterDatabase
    private lateinit var dao: CharacterDao

    @Before
    fun setup(){
      database = Room.inMemoryDatabaseBuilder(
              ApplicationProvider.getApplicationContext(),
               CharacterDatabase::class.java)
              .allowMainThreadQueries()
              .build()

        dao = database.characterDao()
    }

    @After
    fun tierDown(){
        database.close()
    }

    @Test
    fun InsertResult() = runBlocking {
        val result1 = Results("10th march, 2020","Male",1,"James image","James",
                                "Hungarian","Single","Enlish","http://mail.com")

        val result2 = Results("10th march, 2020","Male",2,"James image","James",
                "Hungarian","Single","Enlish","http://mail.com")

        val results = ArrayList<Results>()
        results.add(result1)
        results.add(result2)

        dao.insertResult(results)
        val allresult = dao.getResult()
        assert(results.equals(allresult))
    }

    @Test
    fun deleteResult() = runBlocking{
        val result1 = Results("10th march, 2020","Male",1,"James image","James",
                "Hungarian","Single","Enlish","http://mail.com")

        val result2 = Results("10th march, 2020","Male",2,"James image","James",
                "Hungarian","Single","Enlish","http://mail.com")

        val results = ArrayList<Results>()
        results.add(result1)
        results.add(result2)

        dao.deleteResult()
        val allresult = dao.getResult()
        assert(allresult.isEmpty())
    }
}