package com.example.rickandmortyexamweek2.di.modules

import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepository
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepositoryImp
import com.example.rickandmortyexamweek2.retrofit.RickAndMortyAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRickAndMortyEpisodesRepositoryImp(
        rickAndMortyAPI: RickAndMortyAPI
    ): RickAndMortyEpisodesRepository = RickAndMortyEpisodesRepositoryImp(rickAndMortyAPI)
}