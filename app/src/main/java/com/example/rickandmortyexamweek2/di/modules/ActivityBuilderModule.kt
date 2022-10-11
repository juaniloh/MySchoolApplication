package com.example.rickandmortyexamweek2.di.modules

import com.example.rickandmortyexamweek2.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(
        modules = [

        ]
    )

    abstract fun contributeMainActivity(): MainActivity
}