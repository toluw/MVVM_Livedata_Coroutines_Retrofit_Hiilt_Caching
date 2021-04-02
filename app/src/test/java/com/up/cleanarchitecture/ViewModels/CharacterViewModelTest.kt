package com.up.cleanarchitecture.ViewModels

import com.up.cleanarchitecture.Others.Constants
import com.up.cleanarchitecture.data.model.Results
import com.up.cleanarchitecture.data.repository.FakeMainRepository

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CharacterViewModelTest{
lateinit var viewModel: CharacterViewModel

    @Before
    fun setup(){
        viewModel = CharacterViewModel(FakeMainRepository())
    }

    @Test
    fun `data retrieved`(){
        val results = ArrayList<Results>()
        results.add(Constants.result1)
        results.add(Constants.result2)


        val data = viewModel.data
        val finalresult = data.value

        assert(results.equals(finalresult))
}

}