package com.example.rickandmortyexamweek2.repository.episodes

import com.example.rickandmortyexamweek2.response.RickAndMortyEpisodesResponse

interface RickAndMortyEpisodesRepository {
    suspend fun fetchRickAndMortyEpisodes(): RickAndMortyEpisodesResponse
}
