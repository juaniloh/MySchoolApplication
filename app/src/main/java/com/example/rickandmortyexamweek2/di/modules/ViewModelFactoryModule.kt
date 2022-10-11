package com.example.rickandmortyexamweek2.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyexamweek2.di.viewModel.RickAndMortyEpisodesViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun provideRickAndMortyEpisodesViewModelFactory(
        factory: RickAndMortyEpisodesViewModelFactory
    ): ViewModelProvider.Factory
}