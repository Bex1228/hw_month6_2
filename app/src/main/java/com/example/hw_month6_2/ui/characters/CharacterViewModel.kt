package com.example.hw_month6_2.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_month6_2.data.Character
import com.example.hw_month6_2.data.Repository
import com.example.hw_month6_2.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: Repository
):ViewModel(){
    fun getCharacters():LiveData<Resource<List<Character>>> = repository.getCharacters()
}