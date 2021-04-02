package com.up.cleanarchitecture.ViewModels

import androidx.lifecycle.*
import com.up.cleanarchitecture.data.model.Results
import com.up.cleanarchitecture.data.repository.CharacterRepository
import com.up.cleanarchitecture.data.repository.MainRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
@Inject
constructor(
           mainRepository: MainRepository ): ViewModel(){

              val data = mainRepository.getResults()
}