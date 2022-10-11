package com.example.rickandmortyexamweek2.di.component

import android.app.Application
import com.example.rickandmortyexamweek2.RickAndMortyEpisodesApplication
import com.example.rickandmortyexamweek2.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        RepositoryModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        NetworkLibraryModule::class,
    ]
)

interface AppComponent: AndroidInjector<RickAndMortyEpisodesApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}