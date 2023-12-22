package com.example.hw_month6_2.data


import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    fun getRickAndMorty(): retrofit2.Call<RickAndMortyModel>
}