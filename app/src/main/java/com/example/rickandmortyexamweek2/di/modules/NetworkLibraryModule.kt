package com.example.rickandmortyexamweek2.di.modules

import com.example.rickandmortyexamweek2.retrofit.RickAndMortyAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkLibraryModule {

    private val baseUrl = "https://rickandmortyapi.com/api/"

    @Singleton
    @Provides
     fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideRickAndMortyAPI(retrofit: Retrofit): RickAndMortyAPI =
        retrofit.create(RickAndMortyAPI::class.java)

}
