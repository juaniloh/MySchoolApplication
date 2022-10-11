package com.example.rickandmortyexamweek2.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepository
import com.example.rickandmortyexamweek2.response.RickAndMortyEpisodesResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class RickAndMortyEpisodesViewModel @Inject constructor(
    private val rickAndMortyEpisodesRepository: RickAndMortyEpisodesRepository
): ViewModel() {

    private val _episodes = MutableLiveData<RickAndMortyEpisodesResponse>()
    val episodes: LiveData<RickAndMortyEpisodesResponse> by lazy { _episodes }

    fun fetchRickAndMortyEpisodes() {
        _episodes.postValue(RickAndMortyEpisodesResponse.Loading)
        viewModelScope.launch {
            when (val response = rickAndMortyEpisodesRepository.fetchRickAndMortyEpisodes()) {
                is RickAndMortyEpisodesResponse.Failure -> {
                    Log.e(E_TAG, ERROR_MESSAGE + response.error)
                    _episodes.postValue(RickAndMortyEpisodesResponse.Failure(response.error))
                }
                is RickAndMortyEpisodesResponse.Success -> {
                    Log.i(TAG, SUCCESS_MESSAGE + response.episodes)
                    _episodes.postValue(RickAndMortyEpisodesResponse.Success(response.episodes))
                }
                else -> {
                    Log.i(L_TAG, LOADING_MESSAGE)
                }
            }
        }
    }

    companion object {
        private const val TAG = "SUCCESS"
        private const val E_TAG = "ERROR"
        private const val L_TAG = "LOADING"
        private const val ERROR_MESSAGE = "The error is: "
        private const val SUCCESS_MESSAGE = "This is the list: "
        private const val LOADING_MESSAGE = "Is loading..."
    }
}
