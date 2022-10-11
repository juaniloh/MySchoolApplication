package com.example.rickandmortyexamweek2

import com.example.rickandmortyexamweek2.di.component.DaggerAppComponent
import dagger.android.DaggerApplication

class RickAndMortyEpisodesApplication: DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.factory().create(this)
}