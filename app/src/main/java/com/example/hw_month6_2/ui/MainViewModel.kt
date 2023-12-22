package com.example.hw_month6_2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_month6_2.data.RickAndMortyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    fun getLiveCartoon(): LiveData<RickAndMortyModel>{
        return repository.getData()
    }
}