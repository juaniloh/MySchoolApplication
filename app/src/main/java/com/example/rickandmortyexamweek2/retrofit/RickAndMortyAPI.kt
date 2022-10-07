package com.example.rickandmortyexamweek2.retrofit

import com.example.rickandmortyexamweek2.data.RickAndMortyResponse
import retrofit2.http.GET

interface RickAndMortyAPI {
    @GET("episode")
    suspend fun getAllEpisodes(): RickAndMortyResponse
}
