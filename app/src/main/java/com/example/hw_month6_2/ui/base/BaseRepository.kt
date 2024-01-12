package com.example.hw_month6_2.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.hw_month6_2.data.CartoonApiService
import com.example.hw_month6_2.data.Resource
import kotlinx.coroutines.Dispatchers

open class BaseRepository(private val api: CartoonApiService) {
    protected fun <T> performRequest(apiCall: suspend () -> T): LiveData<Resource<T>> =
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = apiCall.invoke()
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?:e.message.toString()))
            }
        }
}