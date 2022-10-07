package com.example.rickandmortyexamweek2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepository
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepositoryImp
import com.example.rickandmortyexamweek2.response.RickAndMortyEpisodesResponse
import com.example.rickandmortyexamweek2.retrofit.NetworkLibrary
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val repoRick: RickAndMortyEpisodesRepository by lazy {
        RickAndMortyEpisodesRepositoryImp(
            NetworkLibrary.rickAndMortyAPI
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkRickAndMortyEpisodes()
    }

    private fun checkRickAndMortyEpisodes() {
        GlobalScope.launch {
            val response = repoRick.fetchRickAndMortyEpisodes()
            when (response) {
                is RickAndMortyEpisodesResponse.Failure -> Log.e(
                    "E_TAG",
                    "The error is: ${response.error}"
                )
                is RickAndMortyEpisodesResponse.Success -> Log.i(
                    "TAG",
                    "This is the list: ${response.episodes}"
                )
            }
        }
    }
}