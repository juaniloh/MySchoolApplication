package com.example.rickandmortyexamweek2.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkLibrary {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val rickAndMortyAPI: RickAndMortyAPI by lazy {
        retrofit.create(RickAndMortyAPI::class.java)
    }
}
