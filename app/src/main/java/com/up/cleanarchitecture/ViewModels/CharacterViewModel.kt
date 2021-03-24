package com.up.cleanarchitecture.ViewModels

import androidx.lifecycle.*
import com.up.cleanarchitecture.data.model.Results
import com.up.cleanarchitecture.data.repository.CharacterRepository
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
           characterRepository: CharacterRepository ): ViewModel(){

              val data = characterRepository.getResults()
}