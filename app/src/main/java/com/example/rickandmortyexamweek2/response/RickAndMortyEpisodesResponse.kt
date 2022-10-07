package com.example.rickandmortyexamweek2.response

import com.example.rickandmortyexamweek2.data.Results

sealed class RickAndMortyEpisodesResponse {
    data class Success(val episodes: List<Results>): RickAndMortyEpisodesResponse()
    data class Failure(val error:Throwable): RickAndMortyEpisodesResponse()
}
