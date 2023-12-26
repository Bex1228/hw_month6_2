package com.example.hw_month6_2.ui.characterDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw_month6_2.data.Character
import com.example.hw_month6_2.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun getCharacterDetails(sendId: Int): MutableLiveData<Character> =
        repository.getCharacterDetails(sendId)
}