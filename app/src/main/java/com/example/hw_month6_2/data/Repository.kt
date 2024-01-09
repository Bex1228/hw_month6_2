package com.example.hw_month6_2.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class Repository(private val api: CartoonApiService) {

    fun getCharacters(): LiveData<Resource<List<Character>>> = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = api.getCharacters()
            if (response.isSuccessful && response.body() != null) {
                response.body()?.let {
                    emit(Resource.Success(it.results))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        }
    }

    fun getCharacterDetails(id: Int): LiveData<Resource<Character>> = liveData(Dispatchers.IO) {
        try {
            val cartoon = api.getCharacterDetails(id)
            if (cartoon.isSuccessful) {
                cartoon.body()?.let { character->
                    emit(Resource.Success(character))
                }
            }
        } catch (ex: Exception) {
            Log.e("ololo", ex.message.toString())
        }
    }
}