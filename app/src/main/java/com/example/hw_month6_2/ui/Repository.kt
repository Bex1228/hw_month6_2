package com.example.hw_month6_2.ui

import androidx.lifecycle.MutableLiveData
import com.example.hw_month6_2.data.RickAndMortyApi
import com.example.hw_month6_2.data.RickAndMortyModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: RickAndMortyApi) {

    fun getData(): MutableLiveData<RickAndMortyModel> {
        val cartoon = MutableLiveData<RickAndMortyModel>()

        api.getRickAndMorty().enqueue(object :Callback<RickAndMortyModel>{
            override fun onResponse(call: Call<RickAndMortyModel>, response: Response<RickAndMortyModel>) {
                if (response.isSuccessful){
                    response.body().let {
                        if (it != null) {
                            cartoon.postValue(it)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<RickAndMortyModel>, t: Throwable) {}
        })
        return cartoon
    }

}