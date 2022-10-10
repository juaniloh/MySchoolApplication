package com.example.rickandmortyexamweek2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyexamweek2.repository.dI.RepositoryInjection
import com.example.rickandmortyexamweek2.repository.dI.RepositoryInjection.repository
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepository
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepositoryImp

class RickAndMortyEpisodesViewModelFactory: ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RickAndMortyEpisodesViewModel::class.java)) {
            return RickAndMortyEpisodesViewModel(repository) as T
        }
        throw IllegalArgumentException("Model class must be assignable from SchoolViewModel")
    }
}