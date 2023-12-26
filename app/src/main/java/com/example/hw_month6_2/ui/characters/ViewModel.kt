package com.example.hw_month6_2.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_month6_2.data.Character
import com.example.hw_month6_2.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: Repository
):ViewModel(){
    fun getCharacters():LiveData<List<Character>> = repository.getCharacters()
}