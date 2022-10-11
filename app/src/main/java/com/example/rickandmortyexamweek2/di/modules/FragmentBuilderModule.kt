package com.example.rickandmortyexamweek2.di.modules

import com.example.rickandmortyexamweek2.ui.RickAndMortyEpisodesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun provideRickAndMortyEpisodesFragment(): RickAndMortyEpisodesFragment
}