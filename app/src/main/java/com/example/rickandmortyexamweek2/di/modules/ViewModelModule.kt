package com.example.rickandmortyexamweek2.di.modules

import androidx.lifecycle.ViewModel
import com.example.rickandmortyexamweek2.di.viewModel.ViewModelKey
import com.example.rickandmortyexamweek2.ui.RickAndMortyEpisodesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RickAndMortyEpisodesViewModel::class)
    abstract fun provideRickAndMortyEpisodesViewModel(
        viewModel: RickAndMortyEpisodesViewModel
    ): ViewModel
}