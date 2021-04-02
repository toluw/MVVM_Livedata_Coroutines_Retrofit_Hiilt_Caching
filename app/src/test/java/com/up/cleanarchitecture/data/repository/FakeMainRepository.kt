package com.up.cleanarchitecture.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.up.cleanarchitecture.Others.Constants
import com.up.cleanarchitecture.data.model.Results

class FakeMainRepository : MainRepository {

    val results = ArrayList<Results>()







    override fun getResults(): LiveData<List<Results>> {
        results.add(Constants.result1)
        results.add(Constants.result2)
        return MutableLiveData<List<Results>>(results)
    }
}