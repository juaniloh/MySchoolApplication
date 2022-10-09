package com.example.rickandmortyexamweek2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepository
import com.example.rickandmortyexamweek2.repository.episodes.RickAndMortyEpisodesRepositoryImp

class RickAndMortyEpisodesViewModelFactory constructor(
    private val repository: RickAndMortyEpisodesRepository
): ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RickAndMortyEpisodesViewModel::class.java)) {
            return RickAndMortyEpisodesViewModel(repository) as T
        }
        throw IllegalArgumentException("Model class must be assignable from SchoolViewModel")
    }
}