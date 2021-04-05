package com.up.cleanarchitecture.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import com.up.cleanarchitecture.data.model.Results
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class CharacterDaoTest {

    @Inject
    @Named("test_db")
    lateinit var database: CharacterDatabase
    lateinit var dao: CharacterDao

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltRule.inject()
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