package com.example.rickandmortyexamweek2.repository.dI

import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepository
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepositoryImp
import com.example.rickandmortyexamweek2.retrofit.NetworkLibrary

object RepositoryInjection {

    val repository: RickAndMortyEpisodesRepository by lazy {
        RickAndMortyEpisodesRepositoryImp(
            NetworkLibrary.rickAndMortyAPI
        )
    }
}