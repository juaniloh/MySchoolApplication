package com.example.rickandmortyexamweek2.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepository
import com.example.rickandmortyexamweek2.response.RickAndMortyEpisodesResponse
import kotlinx.coroutines.launch

class RickAndMortyEpisodesViewModel(
    private val rickAndMortyEpisodesRepository: RickAndMortyEpisodesRepository
): ViewModel() {

    private val _episodes = MutableLiveData<RickAndMortyEpisodesResponse>()
    val episodes: LiveData<RickAndMortyEpisodesResponse> by lazy { _episodes }

    fun fetchRickAndMortyEpisodes() {
        viewModelScope.launch {
            when (val response = rickAndMortyEpisodesRepository.fetchRickAndMortyEpisodes()) {
                is RickAndMortyEpisodesResponse.Failure -> {
                    Log.e("E_TAG", "The error is: ${response.error}")
                    _episodes.postValue(RickAndMortyEpisodesResponse.Failure(response.error))
                }
                is RickAndMortyEpisodesResponse.Success -> {
                    Log.i("TAG", "This is the list: ${response.episodes}")
                    _episodes.postValue(RickAndMortyEpisodesResponse.Success(response.episodes))
                }
            }
        }
    }

}
