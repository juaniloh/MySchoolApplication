package com.example.rickandmortyexamweek2.repository.episodes

import com.example.rickandmortyexamweek2.response.RickAndMortyEpisodesResponse
import com.example.rickandmortyexamweek2.retrofit.RickAndMortyAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RickAndMortyEpisodesRepositoryImp(
    private val rickAndMortyAPI: RickAndMortyAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): RickAndMortyEpisodesRepository {
    override suspend fun fetchRickAndMortyEpisodes(): RickAndMortyEpisodesResponse =
        withContext(dispatcher) {
            try {
                val response = rickAndMortyAPI.getAllEpisodes()
                return@withContext RickAndMortyEpisodesResponse.Success(response.results)
            } catch (e: Throwable) {
                return@withContext RickAndMortyEpisodesResponse.Failure(e)
            }
        }
}
