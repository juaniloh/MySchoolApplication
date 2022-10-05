package com.example.myapplication.module

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Module {
    private const val URL = "https://data.cityofnewyork.us/resource/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL)
            .build()
    }
}
