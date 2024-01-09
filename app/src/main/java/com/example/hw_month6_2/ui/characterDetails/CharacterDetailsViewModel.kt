package com.example.hw_month6_2.ui.characterDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_month6_2.data.Character
import com.example.hw_month6_2.data.Repository
import com.example.hw_month6_2.data.Resource


class CharacterDetailsViewModel(
    private val repository: Repository
) : ViewModel() {
    fun getCharacterDetails(sendId: Int): LiveData<Resource<Character>> =
        repository.getCharacterDetails(sendId)
}